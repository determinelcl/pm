package com.practice.management.controller;

import com.practice.management.bean.model.ResultModel;
import com.practice.management.bean.entity.Account;
import com.practice.management.bean.entity.EnterpriseResponsibility;
import com.practice.management.bean.entity.SchoolResponsibility;
import com.practice.management.bean.model.AuthModel;
import com.practice.management.constrant.SchoolAndEnpEnum;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class AuthController extends BaseController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    /**
     * 管理员账户登录
     * 角色：管理员
     *
     * @param authModel 认证的信息Model
     * @return 认证成功之后返回Token
     */
    @PostMapping("/auth/ad")
    public ResultModel<String> createAuthTokenForAdmin(@Valid @RequestBody AuthModel authModel) {
        final String token = authService.login(authModel, SchoolAndEnpEnum.ADMIN);
        return success(token);
    }

    /**
     * 学生账户登录
     * 角色：学校学生
     *
     * @param authModel 认证的信息Model
     * @return 认证成功之后返回Token
     */
    @PostMapping("/auth/st")
    public ResultModel<String> createAuthTokenForStudent(@Valid @RequestBody AuthModel authModel) {
        final String token = authService.login(authModel, SchoolAndEnpEnum.STUDENT);
        return success(token);
    }

    /**
     * 学校账户登录
     * 角色：学校负责人、学校老师
     *
     * @param authModel 认证的信息Model
     * @return 认证成功之后返回Token
     */
    @PostMapping("/auth/sc")
    public ResultModel<String> createAuthTokenForSchool(@Valid @RequestBody AuthModel authModel) {
        final String token = authService.login(authModel, SchoolAndEnpEnum.SCHOOL);
        return success(token);
    }

    /**
     * 企业登录
     * 角色：企业负责人、企业老师
     *
     * @param authModel 认证的信息Model
     * @return 认证成功之后返回Token
     */
    @PostMapping("/auth/enp")
    public ResultModel<String> createAuthTokenForEnterprise(@Valid @RequestBody AuthModel authModel) {
        final String token = authService.login(authModel, SchoolAndEnpEnum.ENTERPRISE);
        return success(token);
    }

    /**
     * 刷新Token
     * 角色：所有登录的用户
     *
     * @param request 用户的请求对象
     * @return 刷新之后的Token
     */
    @GetMapping("/refresh")
    public ResultModel<String> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = authService.refresh(token);

        if (refreshToken == null)
            return error("Token刷新失败！");
        else
            return success(refreshToken);
    }

    /**
     * 注册学校负责人
     * 角色：学校负责人、学校老师
     *
     * @param sr 学校负责人数据对象
     * @return 注册的结果信息
     */
    @PostMapping("/auth/sr/reg")
    public ResultModel<Account> registerSR(@Valid @RequestBody SchoolResponsibility sr) {
        sr.setForeignId(sr.getSchoolId());
        authService.register(sr);

        return success("注册成功");
    }

    /**
     * 注册企业负责人
     * 角色：企业负责人、企业老师
     *
     * @param er 企业负责人数据对象
     * @return 册的结果信息
     */
    @PostMapping("/auth/er/reg")
    public ResultModel<Account> registerEr(@Valid @RequestBody EnterpriseResponsibility er) {
        er.setForeignId(er.getEnterpriseId());
        authService.register(er);

        return success("注册成功");
    }


}
