package org.rainbow.meta.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.zhl.config.GrayConfig;

import java.util.Map;

/**
 * @author zhanghanlin
 * @date 2024/4/3
 **/
@Component
@Import(GrayConfig.class)
public class EnvMetaHandler extends AbsMetaHandler {

    public static final String META_CODE = "podEnv";

    @Autowired
    private GrayConfig grayConfig;

    @Override
    protected void process(Map<String, String> metaData) {
        if (grayConfig.getEnable()){
            final String podEnv = System.getProperty(META_CODE);
            metaData.put(META_CODE, podEnv);
        }
    }
}
