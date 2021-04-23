package com.webproject.backend.socketIO;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webproject.backend.Response.Message;
import com.webproject.backend.entity.User;
import com.webproject.backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SocketIOConnectHandler {

    private SocketIOServer server;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public SocketIOConnectHandler(SocketIOServer server,UserMapper mapper,PasswordEncoder passwordEncoder){
        this.server = server;
        this.userMapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @OnConnect
    public void onConnect(SocketIOClient client){
        System.out.println("ok");
        client.sendEvent("connected", Message.newMessage("success"));
        SocketIOSession.CLIENT_MAP.putIfAbsent(client.getSessionId().toString(),client);
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client){
        String id = client.getSessionId().toString();
        SocketIOSession.CLIENT_MAP.remove(id);
        client.sendEvent("disconnected",Message.newMessage("success"));
    }
}
