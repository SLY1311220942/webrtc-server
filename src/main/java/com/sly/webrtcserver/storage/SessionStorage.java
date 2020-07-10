package com.sly.webrtcserver.storage;

import javax.websocket.Session;
import java.util.concurrent.ConcurrentHashMap;

/**
 * websocket 会话存储
 *
 * @author SLY
 * @description
 * @date 2020/7/9
 */
public class SessionStorage {

    private static ConcurrentHashMap<String, Session> storage = new ConcurrentHashMap<>(16);

    public static void saveSession(String userId, Session session) {
        storage.put(userId, session);
    }

    public static Session getSession(String userId) {
        return storage.get(userId);
    }
}
