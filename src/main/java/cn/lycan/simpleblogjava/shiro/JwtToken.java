package cn.lycan.simpleblogjava.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author Makkapakka
 * @date 2022-6-28
 * @package_name cn.lycan.simpleblogjava.shiro
 * @description
 */
public class JwtToken implements AuthenticationToken {
    private String token;
    
    public JwtToken(String token) {
        this.token = token;
    }
    
    @Override
    public Object getPrincipal() {
        return token;
    }
    
    @Override
    public Object getCredentials() {
        return token;
    }
}
