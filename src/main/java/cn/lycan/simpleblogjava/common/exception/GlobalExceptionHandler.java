package cn.lycan.simpleblogjava.common.exception;

/**
 * @author Makkapakka
 * @date 2022-6-28
 * @package_name cn.lycan.simpleblogjava.common.exception
 * @description 有时候不可避免服务器报错的情况，如果不配置异常处理机制，
 * 就会默认返回tomcat或者nginx的5XX页面，对普通用户来说，不太友好，用户也不懂什么情况。
 * <p>
 * 处理办法如：通过使用@ControllerAdvice来进行统一异常处理，
 * @ExceptionHandler(value = RuntimeException.class)来指定捕获的Exception各个类型异常 ，
 * 这个异常的处理，是全局的，所有类似的异常，都会跑到这个地方处理。
 */

import cn.lycan.simpleblogjava.common.lang.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

/**
 * 捕捉了几个异常：
 * ShiroException：shiro抛出的异常，比如没有权限，用户登录异常
 * IllegalArgumentException：处理Assert的异常
 * MethodArgumentNotValidException：处理实体校验的异常
 * RuntimeException：捕捉其他异常
 *
 * @author Makkapakka
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 捕捉shiro异常
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ShiroException.class)
    public Result handle401(ShiroException e) {
        log.error("运行时异常：----------------{}", e);
        return Result.fail(401, e.getMessage(), null);
    }
    
    /**
     * 处理Assert的异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result handler(IllegalArgumentException e) throws IOException {
        log.error("Assert异常:--------------->{}", e);
        return Result.fail(e.getMessage());
    }
    
    /**
     * @Validated 校验错误异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handler(MethodArgumentNotValidException e) {
        log.error("实体校验异常：----------------{}", e);
        BindingResult bindingResult = e.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
        
        return Result.fail(objectError.getDefaultMessage());
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public Result handler(RuntimeException e) {
        log.error("运行时异常：----------------{}", e);
        return Result.fail(e.getMessage());
    }
    
}
