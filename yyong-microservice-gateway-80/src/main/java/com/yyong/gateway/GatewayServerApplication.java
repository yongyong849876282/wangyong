package com.yyong.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableEurekaClient
@SpringBootApplication
public class GatewayServerApplication {
    public static void main(String[] args) {

        SpringApplication.run(GatewayServerApplication.class, args);
    }
}
