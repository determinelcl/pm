
package com.practice.management.bean.model;

import java.io.Serializable;

public class GlobalExceptionInfoModel<T> implements Serializable {

    public static final Integer OK = 0;
    public static final Integer ERROR = 100;
    private static final long serialVersionUID = -6937722414645880868L;

    private Integer code;
    private Object message;
    private T data;
    private String uri;

    public GlobalExceptionInfoModel() {
    }

    public GlobalExceptionInfoModel(Integer code, String message, T data, String uri) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.uri = uri;
    }

    public GlobalExceptionInfoModel(Integer code, Object message, T data, String uri) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.uri = uri;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}