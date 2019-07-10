package com.practice.management.handler;

import com.practice.management.bean.model.GlobalExceptionInfoModel;
import com.practice.management.constant.ResultCode;
import com.practice.management.exception.IdentificationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

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

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public GlobalExceptionInfoModel<String> exceptionForService(HttpServletRequest request, BadCredentialsException e) {
        e.printStackTrace();

        String simpleName = e.getClass().getSimpleName();
        return new GlobalExceptionInfoModel<>(
                ResultCode.EXCEPTION_CODE, "账号或密码错误", simpleName, request.getRequestURI());
    }

    @ExceptionHandler({InternalAuthenticationServiceException.class, IdentificationException.class})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public GlobalExceptionInfoModel<String> exceptionForService(HttpServletRequest request, IdentificationException e) {
        e.printStackTrace();

        String simpleName = e.getClass().getSimpleName();
        return new GlobalExceptionInfoModel<>(
                ResultCode.EXCEPTION_CODE, e.getMessage(), simpleName, request.getRequestURI());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public GlobalExceptionInfoModel<String> validationNotNull(
            HttpServletRequest request, MethodArgumentNotValidException e) {
        e.printStackTrace();

        String simpleName = e.getClass().getSimpleName();
        List<String> messageList = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        return new GlobalExceptionInfoModel<>(
                ResultCode.EXCEPTION_CODE, messageList, simpleName, request.getRequestURI());
    }
}
