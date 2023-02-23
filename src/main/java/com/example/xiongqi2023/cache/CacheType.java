package com.example.xiongqi2023.cache;

import java.util.Objects;

public enum CacheType {
    ADD(1, "add"),
    DELETE(2, "delete");
    private int type;
    private String des;

    CacheType(int type, String des) {
        this.type = type;
        this.des = des;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public static CacheType getType(int type) {
        for (CacheType cacheType : values()) {
            if (Objects.equals(cacheType.getType(), type)) {
                return cacheType;
            }
        }
        return null;
    }
}
