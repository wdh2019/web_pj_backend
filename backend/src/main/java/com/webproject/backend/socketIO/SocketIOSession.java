package com.webproject.backend.socketIO;

import com.corundumstudio.socketio.SocketIOClient;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @description
 * client map保存socketIO连接
 */
public class SocketIOSession {

    public static ConcurrentMap<String, SocketIOClient> CLIENT_MAP = new ConcurrentHashMap<>();
}
