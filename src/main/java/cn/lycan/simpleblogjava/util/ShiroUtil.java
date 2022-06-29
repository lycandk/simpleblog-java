package cn.lycan.simpleblogjava.util;

import cn.lycan.simpleblogjava.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

/**
 * @author Makkapakka
 * @date 2022-6-29
 * @package_name cn.lycan.simpleblogjava.util
 * @description
 */
public class ShiroUtil {
    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}
