package com.webproject.backend.socketIO;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.webproject.backend.Response.Message;
import com.webproject.backend.entity.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SocketIOCommonHandler {

    private SocketIOChatHandler socketIOChatHandler;

    @Autowired
    public SocketIOCommonHandler(SocketIOChatHandler socketIOChatHandler) {
        this.socketIOChatHandler = socketIOChatHandler;
    }

    /**
     * 新用户加入，需要向新用户发送其他用户的位置，棋子的位置；
     * 需要系统公告新用户加入
     * @param client
     * @param ackRequest
     * @param messageInfo
     */
    @OnEvent(value = "joinIn")
    public void joinIn(SocketIOClient client, AckRequest ackRequest, MessageInfo messageInfo) {
        if(!messageInfo.getMessageType().equals("JoinIn")) {
            client.sendEvent("joinIn", Message.newMessage("Wrong Type"));
        }else {
            sendUsersPosition(client.getSessionId().toString());
            sendChessPosition(client.getSessionId().toString());
            socketIOChatHandler.broadcastChat(messageInfo.getUserId(), messageInfo.getUsername());
        }
    }

    /**
     * 将其他玩家的位置信息同步给新加入的玩家
     * @param sessionId
     */
    private void sendUsersPosition(String sessionId) {

    }

    /**
     * 将棋子的位置同步给新玩家
     * @param sessionId
     */
    private void sendChessPosition(String sessionId) {

    }
}
