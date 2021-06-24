package com.webproject.backend.socketIO;

import com.corundumstudio.socketio.SocketIOClient;
import com.webproject.backend.entity.User;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @description
 * client map保存socketIO连接
 * user map保存socketIO与用户的映射
 */
public class SocketIOSession {

    public static ConcurrentMap<String, SocketIOClient> CLIENT_MAP = new ConcurrentHashMap<>();

    public static ConcurrentMap<String, Integer> USER_MAP = new ConcurrentHashMap<>();

    public static ConcurrentMap<Integer, String> USER_POSITION = new ConcurrentHashMap<>();

    public static ConcurrentMap<Integer, String> CHESS_POSITION = new ConcurrentHashMap<>();
}
