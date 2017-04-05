package com.saras.template.core.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.saras.template.utils.ShutdownHooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Map;

/**
 * description:
 * saras_xu@163.com 2017-04-05 15:46 创建
 */
@Configuration
public class DubboRemoteProxyFacotry implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(DubboRemoteProxyFacotry.class.getName());
    private ApplicationContext applicationContext;
    private static volatile Map<Key, ReferenceConfig> cache = Maps.newConcurrentMap();
    private static final int PROVIDER_TIME_OUT = -1;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public <T> T getProxy(Class<T> clazz, String group, String version, int timeout) {
        if ((Strings.isNullOrEmpty(version)) || (clazz == null)) {
            throw new RuntimeException("获取dubbo服务代理时版本号和类不能为空");
        }
        Key key = new Key(clazz, group, version);
        ReferenceConfig cachedReferenceConfig = cache.get(key);
        if (cachedReferenceConfig != null) {
            return (T) cachedReferenceConfig.get();
        }
        if (this.applicationContext == null) {
            throw new RuntimeException("请配置DubboRemoteProxyFacotry到spring容器中");
        }
        synchronized (DubboRemoteProxyFacotry.class) {
            cachedReferenceConfig = cache.get(key);
            if (cachedReferenceConfig == null) {
                ApplicationConfig applicationConfig = this.applicationContext.getBean(ApplicationConfig.class);
                Map registryConfigMap = this.applicationContext.getBeansOfType(RegistryConfig.class);

                if ((registryConfigMap == null) || (registryConfigMap.isEmpty())) {
                    throw new RuntimeException("请配置dubbo基本配置");
                }
                ReferenceConfig reference = new ReferenceConfig();
                reference.setApplication(applicationConfig);
                reference.setRegistries(new ArrayList(registryConfigMap.values()));
                reference.setInterface(clazz);
                reference.setVersion(version);
                reference.setGroup(group);
                if (-1 != timeout) {
                    reference.setTimeout(timeout);
                }
                try {
                    reference.get();
                } catch (Exception e) {
                    logger.error("获取dubbo服务失败:{}", e.getMessage());
                    try {
                        reference.destroy();
                    } catch (Exception e1) {
                        logger.error("获取dubbo服务失败,销毁Invoker失败:{}", e1.getMessage());
                        throw new RuntimeException("获取dubbo服务失败,销毁Invoker失败:" + e.getMessage() + ",cause:" + e.getMessage());
                    }

                    throw new RuntimeException("获取dubbo服务失败:" + e.getMessage());
                }
                cache.put(key, reference);
                cachedReferenceConfig = reference;
            }
            return (T) cachedReferenceConfig.get();
        }
    }

    public <T> T getProxy(Class<T> clazz, String group, String version) {
        return getProxy(clazz, group, version, -1);
    }

    static {
        ShutdownHooks.addShutdownHook(() -> {
            for (ReferenceConfig referenceConfig : DubboRemoteProxyFacotry.cache.values()) {
                try {
                    referenceConfig.destroy();
                } catch (Exception e) {
                    DubboRemoteProxyFacotry.logger.error("{}销毁异常", referenceConfig);
                }
            }
            DubboRemoteProxyFacotry.cache.clear();
        }, "DubboRemoteProxyFacotryShutdownHook");
    }

    private static class Key {
        private Class<?> clazz;
        private String group;
        private String version;

        private Key(Class<?> clazz, String group, String version) {
            this.clazz = clazz;
            this.group = group;
            this.version = version;
        }

        public Class<?> getClazz() {
            return this.clazz;
        }

        public void setClazz(Class<?> clazz) {
            this.clazz = clazz;
        }

        public String getGroup() {
            return this.group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getVersion() {
            return this.version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public boolean equals(Object o) {
            if (this == o)
                return true;
            if ((o == null) || (getClass() != o.getClass())) {
                return false;
            }
            Key key = (Key) o;

            if (this.clazz != null ? !this.clazz.equals(key.clazz) : key.clazz != null)
                return false;
            if (this.group != null ? !this.group.equals(key.group) : key.group != null)
                return false;
            if (this.version != null ? !this.version.equals(key.version) : key.version != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int result = this.clazz != null ? this.clazz.hashCode() : 0;
            result = 31 * result + (this.group != null ? this.group.hashCode() : 0);
            result = 31 * result + (this.version != null ? this.version.hashCode() : 0);
            return result;
        }
    }
}
