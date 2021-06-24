package com.webproject.backend.entity;

import lombok.Data;

@Data
public class MessageInfo {

    int userId;
    String username;
    String message;
    String messageType;
}
