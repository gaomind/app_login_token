package com.mind.app_login_token.service.impl;

import com.mind.app_login_token.entity.User;
import com.mind.app_login_token.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public boolean checkUser(String loginName, String password) {

        return true;
    }

    @Override
    public User getUserByLoginName(String loginName) {
        User user = new User();
        user.setId("2019");
        user.setName("joe");
        user.setAge(18);
        return user;
    }
}
