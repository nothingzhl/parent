package org.zhl.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zhanghanlin
 * @date 2024/4/3
 **/
@Component
public class HeaderInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {

    }
}
