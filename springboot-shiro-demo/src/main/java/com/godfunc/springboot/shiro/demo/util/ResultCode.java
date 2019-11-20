package com.godfunc.springboot.shiro.demo.util;

import com.baomidou.mybatisplus.extension.api.IErrorCode;
import org.springframework.http.HttpStatus;

public enum ResultCode implements IErrorCode {
    /**
     * 失败
     */
    FAILED(-1, "操作失败"),
    /**
     * 成功
     */
    SUCCESS(0, "执行成功"),

    UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), "没有权限"),

    LOGIN_EXPIRED(HttpStatus.UNAUTHORIZED.value(), "请重新登录"),

    NOT_LOGIN(HttpStatus.UNAUTHORIZED.value(), "请先登录");

    private final long code;
    private final String msg;

    ResultCode(final long code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultCode fromCode(long code) {
        ResultCode[] ecs = ResultCode.values();
        for (ResultCode ec : ecs) {
            if (ec.getCode() == code) {
                return ec;
            }
        }
        return SUCCESS;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return String.format(" ErrorCode:{code=%s, msg=%s} ", code, msg);
    }
}