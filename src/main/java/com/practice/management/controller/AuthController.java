package com.practice.management.controller;

import com.practice.management.bean.dto.ResultModel;
import com.practice.management.bean.entity.Account;
import com.practice.management.bean.entity.EnterpriseResponsilbility;
import com.practice.management.bean.entity.SchoolResponsibility;
import com.practice.management.bean.entity.Student;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthController extends BaseController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @PostMapping("/auth")
    public ResultModel<String> createAuthenticationToken(@RequestBody Account request) {
        final String token = authService.login(request.getAccount(), request.getPassword());
        return success(token);
    }

    @GetMapping("/refresh")
    public ResultModel<String> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = authService.refresh(token);

        if (refreshToken == null)
            return error("Token刷新失败！");
        else
            return success(refreshToken);
    }

    @PostMapping("/auth/st/reg")
    public ResultModel<Account> registerStudent(@RequestBody Student student) {
        authService.register(student);

        return success("注册成功");
    }

    @PostMapping("/auth/sr/reg")
    public ResultModel<Account> registerSR(@RequestBody SchoolResponsibility schoolResponsibility) {
        authService.register(schoolResponsibility);

        return success("注册成功");
    }

    @PostMapping("/auth/er/reg")
    public ResultModel<Account> registerStudent(@RequestBody EnterpriseResponsilbility enterpriseResponsilbility) {
        authService.register(enterpriseResponsilbility);

        return success("注册成功");
    }


}
