package cn.lycan.simpleblogjava.service.impl;

import cn.lycan.simpleblogjava.entity.UserEntity;
import cn.lycan.simpleblogjava.mapper.UserMapper;
import cn.lycan.simpleblogjava.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

}
