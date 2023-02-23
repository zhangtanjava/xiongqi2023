package com.example.xiongqi2023.apollo.model;

public enum CommonErrCode {

    /** 响应体错误，数据缺失错误 */
    A300(301, "查询结果为空！"),

    /** 请求体错误，参数错误 */
    A401(401, "请求参数错误！"),
    A402(402, "用户ID不能为空！"),
    A403(403, "新爱用户不存在！"),
    A404(404, "体育号不存在！"),

    /** 系统错误 */
    A500(500, "系统异常"),

    UPLOAD_QIPUID_ERROR(100001, "获取奇谱ID失败"),
    ;

    private int code;

    private String value;

    CommonErrCode(int code, String value) {
        this.value = value;
        this.code=code;
    }

    public int getCode() { return code; }

    public String getValue() {
        return value;
    }

    public static void main(String[] args) {
        System.out.println( CommonErrCode.A500.getValue());
    }
}
