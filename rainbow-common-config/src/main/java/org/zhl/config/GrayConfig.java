package org.zhl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhanghanlin
 * @date 2024/4/3
 **/
@Component
@ConfigurationProperties("rainbow.gray")
public class GrayConfig {
    public static final String PREFIX = "rainbow.gray";

    private Boolean enable = false;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
