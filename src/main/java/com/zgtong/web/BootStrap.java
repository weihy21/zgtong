package com.zgtong.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
@ComponentScan
@SpringBootApplication
@ImportResource("classpath*:/spring/*.xml")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
public class BootStrap extends WebMvcConfigurationSupport {


    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();

            SpringApplication app = new SpringApplication(BootStrap.class);
            ConfigurableApplicationContext appContext = app.run(args);
            BootStrap boot = appContext.getBean(BootStrap.class);
            List<HttpMessageConverter<?>> converts = boot.getMessageConverters();
            //HeaderHttpMessageConverter convert = appContext.getBean(HeaderHttpMessageConverter.class);
            // 清楚无效convert(非必须)
            //converts.clear();
            // 添加唯一的convert , 避免多余的检测
            //converts.add(convert);
            long end = System.currentTimeMillis();

            System.out.println("zgtong-web started in " + (end - start) + "ms .");
        } catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }


    }

}
