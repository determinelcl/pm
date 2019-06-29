package com.practice.management.handler;

import com.practice.management.bean.dto.GlobalExceptionInfoModel;
import com.practice.management.constrant.ResultCode;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class GlobalErrorHandler implements ErrorController {
    private static final String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH)
    public GlobalExceptionInfoModel<String> handleError(HttpServletRequest request, HttpServletResponse response) {
        int status = response.getStatus();

        String message;

        switch (status) {
            case HttpServletResponse.SC_INTERNAL_SERVER_ERROR:
                message = "服务器异常";
                break;
            case HttpServletResponse.SC_NOT_FOUND:
                message = "页面丢失了";
                break;
            case HttpServletResponse.SC_UNAUTHORIZED:
                message = "未认证";
                break;
            case HttpServletResponse.SC_FORBIDDEN:
                message = "接口拒绝访问，用户权限不足";
                break;
            default:
                message = "其他错误发生了";
        }

        return new GlobalExceptionInfoModel<>(
                ResultCode.ERROR_CODE, message, Integer.toString(status), request.getRequestURI());
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
