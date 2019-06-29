package com.practice.management.handler;

import com.practice.management.bean.dto.GlobalExceptionInfoModel;
import com.practice.management.constrant.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus
    public GlobalExceptionInfoModel<String> exception(HttpServletRequest request, Exception e) {

        e.printStackTrace();

        return new GlobalExceptionInfoModel<>(
                ResultCode.EXCEPTION_CODE, e.getMessage(), e.getClass().getSimpleName(), request.getRequestURI());
    }
}
