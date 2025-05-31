package com.cryptowallet.analyticsms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AnalyticsMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnalyticsMsApplication.class, args);
    }

}
