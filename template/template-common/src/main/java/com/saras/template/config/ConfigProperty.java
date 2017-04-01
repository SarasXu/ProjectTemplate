package com.saras.template.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * description:
 * saras_xu@163.com 2017-03-10 10:31 创建
 */
@Configuration
public class ConfigProperty {
    @Value("${user.name.hasee}")
    private String name;
    @Value("${jdbc.connectionURL}")
    private String connectionURL;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.driver}")
    private String driver;

    public String getDriver() {
        return driver;
    }

    public String getConnectionURL() {
        return connectionURL;
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
