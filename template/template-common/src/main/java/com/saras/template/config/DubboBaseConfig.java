package com.saras.template.config;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description:
 * saras_xu@163.com 2017-04-05 13:26 创建
 */
@Configuration
public class DubboBaseConfig {


    /**
     * 设置dubbo扫描包
     */
    @Bean
    public static AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("com.saras.template");
        return annotationBean;
    }

    /**
     * 注入dubbo上下文
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        // 当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("template");
        return applicationConfig;
    }

    /**
     * 注入dubbo注册中心配置,基于zookeeper
     */
    @Bean
    public RegistryConfig registryConfig() {
        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setProtocol("zookeeper");
        registry.setAddress("127.0.0.1:2181");
        return registry;
    }

    /**
     * 默认基于dubbo协议提供服务
     *
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        // 服务提供者协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        protocolConfig.setThreads(200);
        System.out.println("默认protocolConfig：" + protocolConfig.hashCode());
        return protocolConfig;
    }

    /**
     * dubbo服务提供
     */
    @Bean
    public ProviderConfig providerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig, ProtocolConfig protocolConfig) {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setTimeout(3000);
        providerConfig.setRetries(1);
        providerConfig.setDelay(-1);
        providerConfig.setApplication(applicationConfig);
        providerConfig.setRegistry(registryConfig);
        providerConfig.setProtocol(protocolConfig);
        return providerConfig;
    }


//    /**
//     * 服务注册到zookeeper
//     */
//    @Bean
//    public RegistryConfig registry() {
//        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setAddress("127.0.0.1:2181");
//        registryConfig.setProtocol("zookeeper");
//        return registryConfig;
//    }
//
//
//    @Bean
//    public ApplicationConfig application() {
//        ApplicationConfig applicationConfig = new ApplicationConfig();
//        applicationConfig.setName("application_");
//        return applicationConfig;
//    }
//
//    @Bean
//    public MonitorConfig monitorConfig() {
//        MonitorConfig mc = new MonitorConfig();
//        mc.setProtocol("registry");
//        return mc;
//    }
//
//    @Bean
//    public ReferenceConfig referenceConfig() {
//        ReferenceConfig rc = new ReferenceConfig();
//        rc.setMonitor(monitorConfig());
//        return rc;
//    }
//
//    @Bean
//    public ProtocolConfig protocol() {
//        ProtocolConfig protocolConfig = new ProtocolConfig();
//        protocolConfig.setPort(20880);
//        return protocolConfig;
//    }
//
//    @Bean
//    public ProviderConfig provider() {
//        ProviderConfig providerConfig = new ProviderConfig();
//        providerConfig.setMonitor(monitorConfig());
//        return providerConfig;
//    }


}
