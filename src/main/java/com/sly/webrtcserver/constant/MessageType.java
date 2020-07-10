package com.sly.webrtcserver.constant;

/**
 * 消息类型枚举
 *
 * @author sly
 */
public enum MessageType {
    /**
     * 提供者信令
     */
    SIGNALLING_OFFER("提供者信令", "0"),



    ;
    private String name;
    private String code;

    private MessageType(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
