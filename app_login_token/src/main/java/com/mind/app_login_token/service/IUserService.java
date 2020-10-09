package com.mind.app_login_token.service;

import com.mind.app_login_token.entity.User;

public interface IUserService {

    boolean checkUser(String loginName, String password);

    User getUserByLoginName(String loginName);
}
