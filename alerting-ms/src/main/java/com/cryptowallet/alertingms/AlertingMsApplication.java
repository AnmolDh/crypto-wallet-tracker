package com.cryptowallet.alertingms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlertingMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlertingMsApplication.class, args);
    }

}
