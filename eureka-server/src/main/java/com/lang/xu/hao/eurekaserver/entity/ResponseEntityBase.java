package com.lang.xu.hao.eurekaserver.entity;

public class ResponseEntityBase<T> {
    private int code = 1;

    private String message = "success";

    private T data;

    public ResponseEntityBase() {
    }

    public ResponseEntityBase(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
