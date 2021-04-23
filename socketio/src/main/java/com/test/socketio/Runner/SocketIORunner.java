package com.test.socketio.Runner;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SocketIORunner implements CommandLineRunner {

    private final SocketIOServer socketIOServer;

    @Autowired
    public SocketIORunner(SocketIOServer socketIOServer){
        this.socketIOServer = socketIOServer;
    }

    @Override
    public void run(String... args) throws Exception {
        socketIOServer.start();
    }
}
