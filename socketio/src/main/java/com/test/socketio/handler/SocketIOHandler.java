package com.test.socketio.handler;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class SocketIOHandler {

    private final SocketIOServer socketIOServer;

    private final ConcurrentMap<Integer, SocketIOClient> clientMap = new ConcurrentHashMap<>();

    @Autowired
    public SocketIOHandler(SocketIOServer socketIOServer){
        this.socketIOServer = socketIOServer;
    }

    @OnConnect
    public void onConnect(SocketIOClient socketIOClient){

    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient socketIOClient){

    }

    @OnEvent("test")
    public void test(SocketIOClient socketIOClient, AckRequest request, HashMap<String,Object> map){

    }
}
