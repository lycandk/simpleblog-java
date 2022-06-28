package cn.lycan.simpleblogjava.shiro;

import cn.hutool.core.bean.BeanUtil;
import cn.lycan.simpleblogjava.entity.UserEntity;
import cn.lycan.simpleblogjava.service.UserService;
import cn.lycan.simpleblogjava.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Makkapakka
 * @date 2022-6-28
 * @package_name cn.lycan.simpleblogjava.shiro
 * @description AccountRealm是shiro进行登录或者权限校验的逻辑所在，算是核心了，我们需要重写3个方法，分别是:
 * supports：为了让realm支持jwt的凭证校验
 * doGetAuthorizationInfo：权限校验
 * doGetAuthenticationInfo：登录认证校验
 */
@Slf4j
@Component
public class AccountRealm extends AuthorizingRealm {
    
    @Autowired
    JwtUtils jwtUtils;
    
    @Autowired
    UserService userService;
    
    /**
     * shiro默认supports的是UsernamePasswordToken，
     * 而我们现在采用了jwt的方式，所以这里我们自定义一个JwtToken，来完成shiro的supports方法。
     *
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }
    
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
    
    /**
     * doGetAuthenticationInfo登录认证这个方法，可以看到我们通过jwt获取到用户信息，判断用户的状态，
     * 最后异常就抛出对应的异常信息，否者封装成SimpleAuthenticationInfo返回给shiro。
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwt = (JwtToken) token;
        log.info("jwt----------->{}", jwt);
        String userId = jwtUtils.getClaimByToken((String) jwt.getPrincipal()).getSubject();
        UserEntity user = userService.getById(userId);
        if (user == null) {
            log.error("账户不存在！");
            throw new UnknownAccountException("账户不存在");
        }
        if (user.getStatus() == -1) {
            log.error("账户已锁定！");
            throw new LockedAccountException("账户已锁定!");
        }
        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);
        log.info("profile----------------->{}", profile.toString());
        return new SimpleAuthenticationInfo(profile, jwt.getCredentials(), getName());
        
    }
    
    
}
