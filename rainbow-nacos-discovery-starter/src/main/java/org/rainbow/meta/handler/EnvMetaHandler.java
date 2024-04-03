package org.rainbow.meta.handler;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zhanghanlin
 * @date 2024/4/3
 **/
@Component
public class EnvMetaHandler extends AbsMetaHandler {
    public static final String META_CODE = "podEnv";

    @Override
    protected void process(Map<String, String> metaData) {
        final String podEnv = System.getProperty(META_CODE);
        metaData.put(META_CODE, podEnv);
    }
}
