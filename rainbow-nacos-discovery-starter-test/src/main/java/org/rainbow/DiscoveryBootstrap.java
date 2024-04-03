package org.rainbow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhanghanlin
 * @date 2024/4/3
 **/
@SpringBootApplication(scanBasePackages = "org.rainbow" )
@EnableDiscoveryClient
public class DiscoveryBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryBootstrap.class,args);
    }
}
