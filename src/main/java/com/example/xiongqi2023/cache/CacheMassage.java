package com.example.xiongqi2023.cache;

import lombok.Data;

import java.util.List;

@Data
public class CacheMassage {
    /**
     * 操作类型 add 新增  delete 删除
     */
    private int type;
    private List<String> values;

}
