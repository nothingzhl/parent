package org.rainbow.meta.handler;

import lombok.extern.slf4j.Slf4j;
import org.rainbow.meta.MetaHandle;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zhanghanlin
 * @date 2024/4/3
 **/
@Slf4j
public abstract class AbsMetaHandler implements MetaHandle {

    @Override
    public void handle(Map<String, String> metaData) {
        try {
            process(metaData);
        }catch (Exception e){
            log.warn("当前的Meta处理失败!",e);
        }
    }

    protected abstract void process(Map<String,String> metaData);
}
