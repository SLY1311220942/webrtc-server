package com.sly.webrtcserver.socket;

import com.alibaba.fastjson.JSON;
import com.sly.webrtcserver.model.Message;
import com.sly.webrtcserver.storage.SessionStorage;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * webRtc信令服务器
 *
 * @author SLY
 * @description
 * @date 2020/7/9
 */
@Component
@ServerEndpoint(value = "/rtcSocket/{userId}")
public class RtcSocketController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RtcSocketController.class);

    /**
     * 连接开启时操作
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) {
        try {
            if(StringUtils.isNotBlank(userId)){
                SessionStorage.saveSession(userId,session);
            } else {
                // 参数不完整直接关闭连接
                session.close();
            }
        } catch (Exception e){
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            try {
                session.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    /**
     * 发送信息时操作
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        Message mes = JSON.parseObject(message, Message.class);
        LOGGER.info(message);
        // 发送信息
        sendMessageTo(message,mes.getToUserId());

    }

    /**
     * 出错是处理
     * @param t
     */
    @OnError
    public void onError(Throwable t) {
        LOGGER.error(ExceptionUtils.getStackTrace(t));
    }

    /**
     * @param session
     */
    @OnClose
    public void onClose(Session session) {
        LOGGER.info("websocket session close");
    }

    /**
     * 发送消息
     * @param message
     * @param toUserId
     */
    private void sendMessageTo(String message,String toUserId){
        SessionStorage.getSession(toUserId).getAsyncRemote().sendText(message);
    }
}
