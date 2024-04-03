package org.rainbow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zhanghanlin
 * @date 2024/4/3
 **/
@SpringBootApplication(scanBasePackages = "org.rainbow" )
public class DiscoveryBootstrap {
    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(DiscoveryBootstrap.class);

    }
}
