package com.example.xiongqi2023.generator.mapper;

import com.example.xiongqi2023.generator.model.OrderQiyiRequest;

public interface OrderQiyiRequestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderQiyiRequest record);

    int insertSelective(OrderQiyiRequest record);

    OrderQiyiRequest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderQiyiRequest record);

    int updateByPrimaryKeyWithBLOBs(OrderQiyiRequest record);

    int updateByPrimaryKey(OrderQiyiRequest record);
}