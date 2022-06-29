package cn.lycan.simpleblogjava.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.lycan.simpleblogjava.common.lang.Result;
import cn.lycan.simpleblogjava.entity.BlogEntity;
import cn.lycan.simpleblogjava.service.BlogService;
import cn.lycan.simpleblogjava.util.ShiroUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yuwen
 * @since 2022-06-28
 */
@RestController
@Slf4j
public class BlogController {
    
    @Autowired
    BlogService blogService;
    
    @GetMapping("/blogs")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage) {
        Page page = new Page(currentPage, 5);
        IPage pageData = blogService.page(page, new QueryWrapper<BlogEntity>().orderByDesc("created"));
        return Result.succ(pageData);
    }
    
    @GetMapping("/blog/{id}")
    public Result detail(@PathVariable("id") Long id) {
        BlogEntity blogEntity = blogService.getById(id);
        Assert.notNull(blogEntity, "该博客已被删除");
        return Result.succ(blogEntity);
    }
    
    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public Result edit(@Validated @RequestBody BlogEntity blogEntity) {
        BlogEntity temp = null;
        if (blogEntity.getId() != null) {
            temp = blogService.getById(blogEntity.getId());
            // 只能编辑自己的文章
            log.warn(ShiroUtil.getProfile().getId().toString());
            Assert.isTrue(temp.getUserId().longValue() == ShiroUtil.getProfile().getId().longValue(), "没有权限编辑");
        } else {
            temp = new BlogEntity();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(0);
        }
        BeanUtil.copyProperties(blogEntity, temp, "id", "userId", "created", "status");
        blogService.saveOrUpdate(temp);
        
        return Result.succ(null);
    }
    
}
