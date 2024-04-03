package org.rainbow;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.discovery.NacosDiscoveryClientConfiguration;
import com.alibaba.cloud.nacos.discovery.NacosWatch;
import org.rainbow.meta.MetaHandle;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * @author zhanghanlin
 * @date 2024/4/2
 **/
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass({NacosDiscoveryClientConfiguration.class})
@ConditionalOnProperty(name = "spring.cloud.nacos.discovery.server-addr")
@AutoConfigureBefore({NacosDiscoveryClientConfiguration.class})
public class RainbowNacosDiscoveryAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "spring.cloud.nacos.discovery.watch.enabled", matchIfMissing = true)
    public NacosWatch nacosWatch(NacosServiceManager nacosServiceManager,
                                 NacosDiscoveryProperties nacosDiscoveryProperties,
                                 List<MetaHandle> metaHandles) {
        //原来的元数据全部不变
        final Map<String, String> metadata =
                Optional.of(nacosDiscoveryProperties)
                        .map(NacosDiscoveryProperties::getMetadata)
                        .orElseGet(HashMap::new);
        executeHandler(metadata,metaHandles);
        nacosDiscoveryProperties.setMetadata(metadata);
        return new NacosWatch(nacosServiceManager, nacosDiscoveryProperties);
    }

    private void executeHandler(Map<String, String> metaData, List<MetaHandle> metaHandles) {
        Optional.of(metaHandles)
                .orElse(Collections.emptyList())
                .forEach(item -> item.handle(metaData));
    }

}
