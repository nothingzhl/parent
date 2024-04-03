package org.rainbow.meta.handler;

import org.rainbow.meta.MetaHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author zhanghanlin
 * @date 2024/4/3
 **/
public abstract class AbsMetaHandler implements MetaHandle {

    private static final Logger log = LoggerFactory.getLogger(AbsMetaHandler.class);

    @Override
    public void handle(Map<String, String> metaData) {
        try {
            process(metaData);
        } catch (Exception e) {
            log.warn("当前的Meta处理失败!", e);
        }
    }

    protected abstract void process(Map<String, String> metaData);
}
