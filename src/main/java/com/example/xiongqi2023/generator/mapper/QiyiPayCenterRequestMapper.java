package com.example.xiongqi2023.generator.mapper;

import com.example.xiongqi2023.generator.model.QiyiPayCenterRequest;

public interface QiyiPayCenterRequestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QiyiPayCenterRequest record);

    int insertSelective(QiyiPayCenterRequest record);

    QiyiPayCenterRequest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QiyiPayCenterRequest record);

    int updateByPrimaryKeyWithBLOBs(QiyiPayCenterRequest record);

    int updateByPrimaryKey(QiyiPayCenterRequest record);
}