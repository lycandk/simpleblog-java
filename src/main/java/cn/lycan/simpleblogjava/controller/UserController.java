package cn.lycan.simpleblogjava.controller;

import cn.lycan.simpleblogjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    
}
