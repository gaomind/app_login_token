package com.mind.app_login_token.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Created with IDEA
 * author:Mind
 *
 * Date:2019/8/26
 * Time:18:08
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    //https://juejin.im/post/5c3707e46fb9a049f74665ee
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor());
    }

    @Bean
    public TokenInterceptor tokenInterceptor(){
        return new TokenInterceptor();
    }

}
