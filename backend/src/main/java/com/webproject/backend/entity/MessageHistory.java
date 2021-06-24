package com.webproject.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@NoArgsConstructor
public class MessageHistory {

    int historyId;
    @NonNull private Date time;
    @NonNull private int userId;
    @NonNull private String username;
    @NonNull private String messageType;
    @NonNull private String message;

}
