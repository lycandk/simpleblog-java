package cn.lycan.simpleblogjava.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Collections;

/**
 * @author Makkapakka
 * @date 2022-6-28
 * @package_name cn.lycan.simpleblogjava.config
 * @description
 */
@Configuration
@EnableTransactionManagement
@MapperScan("cn.lycan.simpleblogjava.mapper")
public class MybatisPlusConfig {
    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        paginationInnerInterceptor.setMaxLimit(5L);
        paginationInnerInterceptor.setDbType(DbType.MYSQL);
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInnerInterceptor.setOptimizeJoin(true);
        return paginationInnerInterceptor;
    }
    
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.setInterceptors(Collections.singletonList(paginationInnerInterceptor()));
        return mybatisPlusInterceptor;
    }
    
}
