package com.example.xiongqi2023.common.model;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
import java.io.Serializable;

public class Result<T> implements Serializable {
    private Boolean success;
    private String code;
    private T data;
    private String message;

    private Result() {
    }

    public static Result SUCCESS(Boolean success, String code, String message) {
        return SUCCESS(success, code, message, (Object)null);
    }

    public static <T> Result<T> SUCCESS(Boolean success, String code, String message, T data) {
        Result<T> result = new Result();
        result.setSuccess(success);
        result.setCode(code == null ? "" : code);
        result.setMessage(message == null ? "" : message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> clone(Result<T> src) {
        return SUCCESS(src.getSuccess(), src.getCode(), src.getMessage(), src.getData());
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T object) {
        this.data = object;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Result{");
        sb.append("success=").append(this.success);
        sb.append(", code='").append(this.code).append('\'');
        sb.append(", data=").append(this.data);
        sb.append(", message='").append(this.message).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}

