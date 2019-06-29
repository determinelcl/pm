package com.practice.management.controller.common;


import com.practice.management.bean.dto.ResultModel;

public class BaseController {

    // 对返回数据的封装
    protected <T> ResultModel<T> success(T result) {
        return new ResultModel<>(0, "完成", result);
    }

    protected <T> ResultModel<T> success(String message, T result) {
        return new ResultModel<>(0, message, result);
    }

    protected <T> ResultModel<T> success(String message) {
        return new ResultModel<>(0, message, null);
    }

    protected <T> ResultModel<T> error(String message, T result) {
        return new ResultModel<>(1, message, result);
    }

    protected <T> ResultModel<T> error(String message) {
        return new ResultModel<>(1, message, null);
    }

    protected <T> ResultModel<T> result(Integer code, String message) {
        return new ResultModel<>(code, message, null);
    }

    protected <T> ResultModel<T> result(Integer code, String message, T result) {
        return new ResultModel<>(code, message, result);
    }
}
