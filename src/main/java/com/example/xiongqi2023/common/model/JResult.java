package com.example.xiongqi2023.common.model;



import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Type;

public class JResult<T> extends JSONPObject {
    private T meta;
    public static final String DEF_FUNC = "callback";

    public JResult(String function) {
        this(function, (T) null);
    }

    public JResult(String function, T meta) {
        super(function);
        this.meta = meta;
        if (meta != null) {
            super.addParameter(meta);
        }

    }

    public void write(JSONSerializer serializer, Object fieldName, Type fieldType, int features) throws IOException {
        if (StringUtils.isNotEmpty(this.getFunction())) {
            super.write(serializer, fieldName, fieldType, features);
        } else {
            serializer.write(this.meta);
        }

    }

    public T getMeta() {
        return this.meta;
    }
}
