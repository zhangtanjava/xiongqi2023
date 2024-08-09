package com.example.xiongqi2023.caipiao.service.impl;

import com.example.xiongqi2023.caipiao.domian.ShuangSeQiu;
import com.example.xiongqi2023.caipiao.mapper.ShuangSeQiuMapper;
import com.example.xiongqi2023.caipiao.service.CaipiaoService;
import com.example.xiongqi2023.caipiao.service.ShuangSeQiuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CaipiaoServiceImpl implements CaipiaoService {
    @Autowired
    ShuangSeQiuService shuangSeQiuService;

    @Override
    public void readCvsAndSave(String fileName) {

        // 方法一读取CSV文件，该方法中FileReader 类是用于读取字符文件的，但它默认使用平台默认的字符编码
        FileReader reader = null;
        CSVParser parser = null;

        try {
            reader = new FileReader(fileName);
            parser = new CSVParser(reader, CSVFormat.DEFAULT);
            //定义List用于接收文件数据
            List<ShuangSeQiu> shuangSeQius = new ArrayList<>();

            // 遍历CSV文件的每一行并获取单元格数据
            for (CSVRecord record : parser) {
                ShuangSeQiu shuangSeQiu = new ShuangSeQiu();

                shuangSeQiu.setIssue(Integer.valueOf(record.get(1)));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String openTime = record.get(2);
                try {
                    shuangSeQiu.setOpenTime(simpleDateFormat.parse(openTime));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                shuangSeQiu.setRedBall(record.get(3));
                shuangSeQiu.setBlackBall(Integer.valueOf(record.get(4)));

                shuangSeQius.add(shuangSeQiu);
            }
            // 关闭流
            parser.close();
            reader.close();

            shuangSeQiuService.saveBatch(shuangSeQius,shuangSeQius.size());

        } catch (Exception e) {
            log.info("readCvsAndSave 异常:{}", e.getMessage());
        }

    }
}
