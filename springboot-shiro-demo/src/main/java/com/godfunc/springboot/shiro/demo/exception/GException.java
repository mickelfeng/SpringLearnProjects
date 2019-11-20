package com.godfunc.springboot.shiro.demo.exception;

import com.baomidou.mybatisplus.extension.api.IErrorCode;

/**
 * 自定义异常
 */
public class GException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private long code = 500;

    public GException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public GException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public GException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public GException(IErrorCode iErrorCode) {
        super(iErrorCode.getMsg());
        this.msg = iErrorCode.getMsg();
        this.code = iErrorCode.getCode();
    }

    public GException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }


}
