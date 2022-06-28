package cn.lycan.simpleblogjava.shiro;

import lombok.Data;

/**
 * @author Makkapakka
 * @date 2022-6-28
 * @package_name cn.lycan.simpleblogjava.shiro
 * @description 登录成功之后返回的一个用户信息的载体
 */
@Data
public class AccountProfile {
    private Long id;
    private String username;
    private String avatar;
}
