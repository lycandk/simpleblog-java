package cn.lycan.simpleblogjava.service.impl;

import cn.lycan.simpleblogjava.entity.BlogEntity;
import cn.lycan.simpleblogjava.mapper.BlogMapper;
import cn.lycan.simpleblogjava.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuwen
 * @since 2022-06-28
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, BlogEntity> implements BlogService {

}
