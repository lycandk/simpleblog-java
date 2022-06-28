package cn.lycan.simpleblogjava.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import cn.lycan.simpleblogjava.common.dto.LoginDto;
import cn.lycan.simpleblogjava.common.lang.Result;
import cn.lycan.simpleblogjava.entity.UserEntity;
import cn.lycan.simpleblogjava.service.UserService;
import cn.lycan.simpleblogjava.util.JwtUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Makkapakka
 * @date 2022-6-28
 * @package_name cn.lycan.simpleblogjava.controller
 * @description 登录的逻辑其实很简答，只需要接受账号密码，然后把用户的id生成jwt，返回给前段，为了后续的jwt的延期，所以我们把jwt放在header上。
 */
@RestController
public class AccountController {
    @Autowired
    UserService userService;
    
    @Autowired
    JwtUtils jwtUtils;
    
    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse httpServletResponse) {
        UserEntity user = userService.getOne(new QueryWrapper<UserEntity>().eq("username", loginDto.getUsername()));
        Assert.notNull(user, "用户不存在");
        
        if (!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))) {
            return Result.fail("密码不正确");
        }
        String jwt = jwtUtils.generateToken(user.getId());
        
        httpServletResponse.setHeader("Authorization", jwt);
        httpServletResponse.setHeader("Access-control-Expose-Headers", "Authorization");
        
        return Result.succ(MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUsername())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .map()
        );
    }
    
    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }
}

