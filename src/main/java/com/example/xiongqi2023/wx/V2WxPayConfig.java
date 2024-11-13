package com.example.xiongqi2023.wx;

import com.github.wxpay.sdk.WXPayConfig;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
@Service
public class V2WxPayConfig implements WXPayConfig {
    private byte[] certData;
    private String appId = WxPayConfigs.APPID;//微信提供的appid todo h5 wx76eb420ae38e2ea6
    private String wxPayKey = WxPayConfigs.KEY;//微信提供的密钥
    private String wxPayMchId = WxPayConfigs.MCHID;//微信提供的商务id
    //本地证书路径
    private String linuxOS = "/Users/zhangtan/Desktop/1547111171_20191030_cert/apiclient_cert.p12";
    private String windowsOS = "D:\\work\\mj_mall\\jeecg-cloud\\key\\apiclient_cert.p12";
    private String privateKey = WxPayConfigs.PRIVATE_KEY;

    @Override
    public String getAppID() {
        return appId;
    }

    @Override
    public String getMchID() {
        return wxPayMchId;
    }

    @Override
    public String getKey() {
        return wxPayKey;
    }

    @Override
    public InputStream getCertStream() {
        return new ByteArrayInputStream(this.certData);
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 0;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 0;
    }


    /**
     * 构造方法读取证书, 通过getCertStream 可以使sdk获取到证书
     */
    public V2WxPayConfig() throws Exception {
        //通过服务操作系统判断使用的证书地址，win 和 linux 路径不通
        String property = System.getProperty("os.name");
        File file = null;
//        if (property.contains("Windows") || property.contains("windows")) {
//            file = new File(windowsOS);
//        } else {
//            file = new File(linuxOS);
//        }
        file = ResourceUtils.getFile("classpath:apiclient_cert.p12");
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

}
