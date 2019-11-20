package com.godfunc.websocket.demo.handler;

import com.godfunc.websocket.demo.domain.WebSocketUserAuthentication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 用户信息认证
 **/
@Slf4j
public class MyPrincipalHandshakeHandler extends DefaultHandshakeHandler {


    /**
     * 将user与websocket进行关联
     * @param request
     * @param wsHandler
     * @param attributes
     * @return
     */
    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {

        HttpSession httpSession = getSession(request);
        // 获取登录的信息，就是controller 跳转页面存的信息，可以根据业务修改
        String user = (String) httpSession.getAttribute("loginName");

        if (user == null || user.equals("")) {
            log.error("未登录系统，禁止登录websocket!");
            return null;
        }
        log.info(" MyDefaultHandshakeHandler login = " + user);
        String s = String.valueOf(LocalDateTime.now().getSecond());
        // log.info(" MyDefaultHandshakeHandler loginrandom = " + LocalDateTime.now().getSecond());
        // return new WebSocketUserAuthentication(s);
        return new WebSocketUserAuthentication(user);
    }

    private HttpSession getSession(ServerHttpRequest request) {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
            return serverRequest.getServletRequest().getSession(false);
        }
        return null;
    }

}
