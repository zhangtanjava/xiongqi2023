package com.example.xiongqi2023.wx;

import com.github.wxpay.sdk.WXPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class V2WxPayService {

    @Autowired
    private V2WxPayConfig v2WxPayConfig;

    public static void main(String[] args) throws IOException {
//        refundOrder("");

        File file = new File("/Users/zhangtan/Desktop/refund.txt"); // 1. 创建File对象，指定要读取的文件路径

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(file); // 2. 创建FileReader对象，用于读取文件
            bufferedReader = new BufferedReader(fileReader); // 3. 创建BufferedReader对象，用于按行读取文件内容
            StringBuilder stringBuilder = new StringBuilder(); // 4. 创建StringBuilder对象，用于存储文件内容

            String line;
            while ((line = bufferedReader.readLine()) != null) { // 5. 逐行读取文件内容
                String[] lines = line.split(" ");
                String orderId = lines[0];
                String fee = lines[1];
                BigDecimal mult = new BigDecimal(100);
                Integer refundFee = new BigDecimal(fee).multiply(mult).intValue();
                 refundOrder(orderId,refundFee.toString());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close(); // 7. 关闭BufferedReader
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



    public static String refundOrder( String orderId,String refundFee) {
        try {
            Map<String, String> map = new HashMap<>();
            map.put("appid", "wx9618fb9297783a6d");
            map.put("mch_id", "1547111171");
//            map.put("transaction_id", "4200002402202409082963577502");
            map.put("out_trade_no", orderId);//商户订单号
            String refundId = UUID.randomUUID().toString().replace("-","");
            map.put("out_refund_no", refundId);//商户退款单号
            map.put("total_fee", refundFee);//退款金额
            map.put("refund_fee", refundFee);//退款金额
            map.put("refund_fee_type", "CNY");//币制，固定CNY，国内
            map.put("notify_url", "https://recapi-dev.ssports.com/weixinNotify");

            //微信官方提供的SDK，下载可以之间调用，不需要写API
            V2WxPayConfig v2WxPayConfig = new V2WxPayConfig();
            WXPay wxpay = new WXPay(v2WxPayConfig);
            //申请退款
            Map<String, String> refundMap = wxpay.refund(map);
            String returnCode = refundMap.get("return_code");
            String errCodeDes = refundMap.get("err_code_des");
            String errCode = refundMap.get("err_code");

            if("SUCCESS".equals(returnCode)){
                String transaction_id = refundMap.get("transaction_id");
                String out_trade_no = refundMap.get("out_trade_no");
                String out_refund_no = refundMap.get("out_refund_no");
                String refund_id = refundMap.get("refund_id");
                String refund_fee = refundMap.get("refund_fee");
                StringBuilder str = new StringBuilder();
                str.append(transaction_id).append("|")
                        .append(out_trade_no).append("|")
                        .append(out_refund_no).append("|")
                        .append(refund_id).append("|")
                        .append(refund_fee);
                System.out.println("申请退款成功:"+str.toString());
                return str.toString();

            } else {
                System.out.println("申请退款失败:"+orderId+"|"+refundFee+"|"+returnCode+"|"+errCode+"|"+errCodeDes);
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
