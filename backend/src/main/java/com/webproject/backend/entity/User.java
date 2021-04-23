package com.webproject.backend.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    int userId;
    @NonNull String username;
    @NonNull String password;
}
