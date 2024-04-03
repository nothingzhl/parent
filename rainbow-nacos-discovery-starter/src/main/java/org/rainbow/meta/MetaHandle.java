package org.rainbow.meta;

import java.util.Map;

@FunctionalInterface
public interface MetaHandle {
    void handle(Map<String,String> metaData);
}
