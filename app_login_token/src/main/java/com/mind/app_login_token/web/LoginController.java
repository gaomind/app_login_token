package com.mind.app_login_token.web;

import com.mind.app_login_token.entity.ResponseResult;
import com.mind.app_login_token.entity.User;
import com.mind.app_login_token.service.IUserService;
import com.mind.app_login_token.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private IUserService userService;

    /**
     * 登陆接口
     *
     * @return token
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult login(@RequestBody Map<String, String> map) {
        String loginName = map.get("loginName");
        String password = map.get("password");
        //身份验证是否成功
        boolean isSuccess = userService.checkUser(loginName, password);
        if (isSuccess) {
            User user = userService.getUserByLoginName(loginName);
            if (user != null) {
                //返回token
                String token = JwtUtil.sign(user.getName(), user.getId());
                if (token != null) {
                    return ResponseResult.success(token,null);
                }
            }
        }
        //返回登陆失败消息
        return ResponseResult.fail(-100,"登陆失败",null);
    }

}
