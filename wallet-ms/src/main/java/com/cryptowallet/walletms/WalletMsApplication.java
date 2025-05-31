package com.cryptowallet.walletms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WalletMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletMsApplication.class, args);
    }

}
