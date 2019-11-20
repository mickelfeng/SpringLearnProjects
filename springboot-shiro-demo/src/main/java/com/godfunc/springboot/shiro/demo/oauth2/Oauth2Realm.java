package com.godfunc.springboot.shiro.demo.oauth2;

import com.godfunc.springboot.shiro.demo.entity.UserTokenEntity;
import com.godfunc.springboot.shiro.demo.exception.GException;
import com.godfunc.springboot.shiro.demo.service.UserService;
import com.godfunc.springboot.shiro.demo.service.UserTokenService;
import com.godfunc.springboot.shiro.demo.user.UserDetail;
import com.godfunc.springboot.shiro.demo.util.JwtUtils;
import com.godfunc.springboot.shiro.demo.util.ResultCode;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 认证
 *
 * @author Mark sunlightcs@gmail.com
 */
public class Oauth2Realm extends AuthorizingRealm {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserService userService;
    @Autowired
    private UserTokenService userTokenService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof Oauth2Token;
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserDetail user = (UserDetail) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 设置用户权限
        info.setStringPermissions(user.getPermissions());
        // 设置用户角色
        info.setRoles(user.getRoles());
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();
        Claims claims = jwtUtils.getClaimByToken(accessToken);
        if (claims == null || jwtUtils.isTokenExpired(claims.getExpiration())) {
            throw new GException(ResultCode.LOGIN_EXPIRED);
        }
        //根据accessToken，查询用户信息
        UserTokenEntity tokenEntity = userTokenService.getByToken(accessToken);
        //token失效
        if (tokenEntity == null) {
            throw new GException(ResultCode.LOGIN_EXPIRED);
        }
        //查询用户信息
        UserDetail userDetail = userService.getUserDetail(tokenEntity.getUserId());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userDetail, accessToken, getName());
        return info;
    }

}