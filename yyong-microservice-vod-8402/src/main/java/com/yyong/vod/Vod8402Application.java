package com.yyong.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages={"com.yyong.vod","com.yyong.common"})
public class Vod8402Application {
    public static void main(String[] args) {
        SpringApplication.run(Vod8402Application.class, args);
    }
}
