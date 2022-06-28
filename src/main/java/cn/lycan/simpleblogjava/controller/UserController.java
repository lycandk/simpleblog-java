package cn.lycan.simpleblogjava.controller;

import cn.lycan.simpleblogjava.entity.UserEntity;
import cn.lycan.simpleblogjava.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yuwen
 * @since 2022-06-28
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    
    @GetMapping("/{id}")
    public Object user(@PathVariable("id") long id) {
        return userService.getById(id);
    }
    
    /**
     * 测试实体校验
     * 测试未通过，校验未生效
     *
     * @param user
     * @return
     */
    @PostMapping("/save")
    public Object save(@RequestBody @Valid UserEntity user) {
        return user;
    }
    
}
