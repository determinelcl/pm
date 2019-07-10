package com.practice.management.filter;

import com.practice.management.bean.entity.Menu;
import com.practice.management.bean.entity.Role;
import com.practice.management.bean.model.JwtUser;
import com.practice.management.constant.RequestAttrConstant;
import com.practice.management.mapper.MenuMapper;
import com.practice.management.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 对用户的角色权限进行验证
 */
@Component
public class RoleAuthFilter extends OncePerRequestFilter {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        JwtUser user = (JwtUser) request.getAttribute(RequestAttrConstant.FILTER_REQUEST_USER);
        if (user == null || request.getRequestURI()
                .substring(request.getRequestURI().lastIndexOf('/')).equals("/refresh")) {
            filterChain.doFilter(request, response);
            return;
        }

        Long roleId = user.getRoleId();

        // 验证url是否具有访问权限
        String requestURL = request.getRequestURI();
        List<Menu> menuList = menuMapper.findByRoleId(roleId);
        for (Menu menu : menuList) {
            if (!menu.getMenuUrl().equals(requestURL)) continue;

            // 验证对url是否具有操作权限
            if (!isHasAuthority(roleId, request.getMethod().toUpperCase()))
                throw new RuntimeException(String.format("没有%s操作权限：%s", request.getMethod(), requestURL));

            filterChain.doFilter(request, response);
        }

        throw new RuntimeException("页面不存在/没有权限访问：" + requestURL);
    }

    /**
     * 根据指定的角色id和指定的请求方法验证是否有权限访问用户请求的方法
     *
     * @param roleId 角色id
     * @param method 请求方法
     * @return 如果具有操作权限返回true，否则返回false
     */
    private boolean isHasAuthority(Long roleId, String method) {
        Role role = roleMapper.findById(roleId);
        return role.getAuthorities().contains(method);
    }
}
