package com.godfunc.springboot.shiro.demo.config;

import com.baomidou.mybatisplus.extension.api.R;
import com.godfunc.springboot.shiro.demo.exception.GException;
import com.godfunc.springboot.shiro.demo.util.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GExceptionHandler {

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(GException.class)
	public R handleRRException(GException e){
		return R.failed(e.getMsg()).setCode(e.getCode());
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public R handleDuplicateKeyException(DuplicateKeyException e){
		log.error(e.getMessage(), e);
		return R.failed("数据库中已存在该记录");
	}

	@ExceptionHandler(Exception.class)
	public R handleException(Exception e){
		log.error(e.getMessage(), e);
		return R.failed(e.getMessage());
	}
	@ExceptionHandler(AuthorizationException.class)
	public R authorizationException(AuthorizationException e){
		log.error(e.getMessage(), e);
		return R.failed(ResultCode.UNAUTHORIZED);
	}
}
