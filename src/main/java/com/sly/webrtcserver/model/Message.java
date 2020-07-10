package com.sly.webrtcserver.model;

import java.io.Serializable;

/**
 * socket消息model
 *
 * @author SLY
 * @description
 * @date 2020/7/10
 */
public class Message implements Serializable {

    private String event;

    private Object data;

    private String sendUserId;

    private String toUserId;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }
}
