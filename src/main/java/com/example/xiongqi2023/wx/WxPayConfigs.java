package com.example.xiongqi2023.wx;


/**
 * @Author chenzf
 * @Description 微信支付配置
 * @Date 2020/02/07 11:32
 */
public class WxPayConfigs {
    /**
     * 应用id(APP 使用)
     */
    public static String APPID = "wx9618fb9297783a6d";
    /**
     * 应用id(PC H5 使用)
     */
    public static String APPID_PC_H5 = "wx76eb420ae38e2ea6";
    /**
     * 商户id
     */
    public static String MCHID = "1547111171";
    /**
     * 加密key, 回调验签用
     */
    public static String KEY = "Ab560gv1kMNuEu7SsWD0EPEh279MObQx";
    public static String APPSECRET = "ecb66c06b4dbdbd63ed55858441ec599";

    public static String PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQDVGR/kSUfAugEwf9bpLNOElkQNVsHvOwiJBr2H5//tjv5wKgK3+QwP9fosK1ragyfUlH0Kwylo3WtdlM2AifLqQ22J1TFhcaIUDXzjARX5H4tmeAIHAewGkg+Rhj1MrGu4vSYmY5YEEMWwyyYgtHwc2CcMMUAjHe0axakavTfJTIq/bVKu+40ythAetmvE8ajPgGnCO5AnrmzktICoqcF3D61fk7594SidSG74BBc6IsaLU2jdwxXgpyaiyFYxF2uRx+p//ffkoHGhoSB9CW47tK+ulRjw9xRzElSY/mO5kCnSLEAnzlr7al+1JBqGtiPIFQXPZL2KRfz2Xc13AltlAgMBAAECggEBAMQ8SckQznmlEDlYUFETzYi4U9ywuxCRnU+KHHkN5PkfiCFEHpLKThhYnNOV7SlyQ/iX8Po7NGP0Gs3nnMK0xjSCeVnHMJ0aZnXu4cWtl019hgKLmtpXI8H9OUb6hnKYCO7riDkr1dbSlyoyOV8+tVhemL66j+SGx3Sy9wG/o6LDIhrjt9uk7kKfljQE6WDo2Lk6Rw4dPzo1FelLIJwSforP7VDUGdpe8b6aGmeFVUhMBlEIH/6j7ED3Q5i1hVeOPT1zAOIJkULA8r0JiK1k3O7g9X54LrGYVMTfFmo1oXR/mMT0EGqwO1oa+TNUXdvqaP6ExmHW/wySwBaJ9igx41UCgYEA9EXG8vT90FVRkqRvjBiYxX7JyyFe1Ksm18Ct3ffzWQzQgMQmWzXBxQc43mFrtAHaDsSeuJeSRsbP0EcLOVWvOLiQ7FAHozCeNb3RlRsolgSFlTSsH4hUJZ3mVfIpJ2JWllGa2miD+/6gVSE4i8UbDo94jSsz390xa9mUjT8SwKcCgYEA31QzB9NJRdcgwuBCS4pAEPHPdoUehrqF4HlyuyTKVV8+47ZCbX1nxpWdtY/Uo8HISfnCRVejQ1lv4nmuc+Hv4Agqthr66SqnBgf5wImLueibv5amZLlrDbD6C7PeMz3MjQxLlnUcSZK6lBbA4BWHmbc26ctd9RAxKraBow+8WRMCgYEAwxZ7VwztLRcG6Bwl7niygoDJP08ugqESi5uaAL4HfyZp231MuOnNEMO82nZp40DbW5ISxZBgReCAlnI295qEL8PQEruz7dRldrxcBz7CglWoLkr78M8bjVN3Y0rdLVQvnSwdhbOVPYvVl0fJ9m78NfvFptFLQ85PqzgBmXE3U98CgYEAmI0sepjyQVnNUDDeODmMv8Zd3+jYzFFXJ9nt7DYaXCy+ic+zGpWCMN18qExChUXWqemIsdNGe7f5PGvAJfpc39zUSCav5Fw1UWJbURDjuC9TTJD8wmsB3I1akGniS4BYXLTcYT9H/l3TQ1szjx5FzVOgmB1J5h+UZkfaz+bs0q8CgYEAykQI3I8eLPAiIAU/SNc/V1oVEDLggq6bE5ZL4v5pFLAOGowXjif0pdVD7bpqvd0EWT5MFP64//itE56u8s2UtdkxS8jE1th70XLChEGy8I4EtHAnNkR94ANLejvyLWWy/2LtI8HvQw77xfmUng4/TT8t4BTf4soBifwQ7SlOWF8=-----END PRIVATE KEY-----";

    public static String CERT_NUM = "6088B683601A5891C8CF5149B1A02810D4C58949";
    /**
     * 获取公众号时用这个参数
     */
    public final static String WEIXIN_OAUTH2_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";
    /**
     * 支付状态查询，有回调result_code=success 则不用查询吧
     */
    public static String ORDERQUERY_URL = "https://api.mch.weixin.qq.com/pay/orderquery";
    /**
     * 支付状态查询，有回调result_code=success 则不用查询吧
     */
    public static String ORDERQUERY_REFUND = "https://api.mch.weixin.qq.com/secapi/pay/refund";

    /**
     * 调用统一支付接口 预下单
     */
    public static String preOrderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    /**
     * 支付中签约接口
     */
    public static String paySignUrl = "https://api.mch.weixin.qq.com/pay/contractorder";
    /**
     * APP纯签约 预签约
     */
    public static String preSignUrl = "https://api.mch.weixin.qq.com/papay/preentrustweb";
    /**
     * 公众号纯签约
     */
    public static String jsSignUrl = "https://api.mch.weixin.qq.com/papay/entrustweb";
    /**
     * h5纯签约
     */
    public static String h5SignUtl = "https://api.mch.weixin.qq.com/papay/h5entrustweb";
    /**
     * 查询签约接口
     */
    public static String querySignUrl = "https://api.mch.weixin.qq.com/papay/querycontract";
    /**
     * 主动解约接口
     */
    public static String unbindUrl = "https://api.mch.weixin.qq.com/papay/deletecontract";
    /**
     * //微信统一下单
     */
    public static String unifiedorderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    /**
     * 支付中代扣接口
     */
    public static String pappayapply = "https://api.mch.weixin.qq.com/pay/pappayapply";


}
