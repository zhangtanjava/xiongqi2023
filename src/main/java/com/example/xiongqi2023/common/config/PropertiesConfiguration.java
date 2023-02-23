package com.example.xiongqi2023.common.config;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * @author yvioo
 */
@Configuration
public class PropertiesConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        // 加载自定义yml文件
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        // 加载YML格式自定义配置文件 这里的 front.yml 为你新建的放在根目录下的 yml文件名称
//        new InputStreamResource(Files.newInputStream(Paths.get("redis.properties"))); // 自定义文件的路径
        yaml.setResources(new ClassPathResource("apollo.yml"));// 加载resources下面的路径
        configurer.setProperties(yaml.getObject());
        return configurer;
    }
}
