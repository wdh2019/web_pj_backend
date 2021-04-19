package com.webproject.backend.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class ExampleUser {

    @NonNull String username;
    @NonNull String password;
}
