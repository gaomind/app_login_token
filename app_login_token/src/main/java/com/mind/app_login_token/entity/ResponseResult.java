package com.mind.app_login_token.entity;

import java.io.Serializable;
import java.util.Map;

public class ResponseResult implements Serializable {

    private static final long serialVersionUID = -999362211833007653L;

    /**
     * 是否成功，成功找data、失败找msg
     */
    protected final boolean success;

    /**
     * 返回结果编码，成功的话我喜欢设为0
     */
    protected final int code;

    /**
     * 返回消息，一般放置可追溯的错误消息
     */
    protected final String msg;

    /**
     * 返回数据
     */
    protected final Object data;

    /**
     * 额外参数,不使用Map<String, Object>防止JSON解析时过于复杂
     */
    protected final Map<String, String> extraInfo;

    private ResponseResult(boolean success, int code, String msg, Object data, Map<String, String> extraInfo) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data=data;
        this.extraInfo = extraInfo;
    }

    public static ResponseResult fail(int code, String msg, Map<String, String> extraInfo){
        return new ResponseResult(false,code,msg,null,extraInfo);
    }

    public static ResponseResult success(Object data, Map<String, String> extraInfo){
        return new ResponseResult(true,0,"",data,extraInfo);
    }

}
