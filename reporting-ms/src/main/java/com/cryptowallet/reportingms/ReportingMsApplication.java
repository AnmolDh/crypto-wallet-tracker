package com.cryptowallet.reportingms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ReportingMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportingMsApplication.class, args);
    }

}
