package org.rainbow;

import com.alibaba.cloud.nacos.NacosConfigAutoConfiguration;
import com.alibaba.cloud.nacos.NacosConfigBootstrapConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhanghanlin
 * @date 2024/4/2
 **/
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass({NacosConfigBootstrapConfiguration.class, NacosConfigAutoConfiguration.class})
@ConditionalOnProperty(name = "spring.cloud.nacos.config.enabled", matchIfMissing = true)
public class RainbowNacosDiscoveryAutoConfiguration {


}
