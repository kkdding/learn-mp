package com.ding.learnmp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ding.learnmp.model.entity.User;
import com.ding.learnmp.service.UserService;
import com.ding.learnmp.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Dding
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-08-11 12:30:28
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




