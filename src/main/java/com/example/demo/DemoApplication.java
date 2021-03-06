package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@Configuration

@EnableTransactionManagement
@SpringBootApplication
@ComponentScan
public class DemoApplication {
    public static void main(String[] args) {
        System.out.println("启动springboot服务器------------------");
        SpringApplication.run(DemoApplication.class, args);
    }


    /**
     * TODO @EnableTransactionManagement
     * <p>
     * 1.类似<tx:annotation-driven></>
     */

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }


}
