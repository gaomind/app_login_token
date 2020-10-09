package com.mind.app_login_token.web;

import com.mind.app_login_token.entity.ResponseResult;
import com.mind.app_login_token.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mind
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult getUser() {
        return ResponseResult.success(userService.getUserByLoginName(""), null);
    }
}
