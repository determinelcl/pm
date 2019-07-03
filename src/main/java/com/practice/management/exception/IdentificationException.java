package com.practice.management.exception;

/**
 * 标识异常：目前采用的时未找到对应的id（企业id和学校id）
 */
public class IdentificationException extends RuntimeException {

    public IdentificationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
