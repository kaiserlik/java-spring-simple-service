package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration("proxyBeanMethods")
public class App {

    public static void main(String[] args){
        SpringApplication.run(App.class, args);
    }

}