package com.example.InternProject.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    private Long user_ID;
    private String name;
    private String email;
    private String role;
    private String gender;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
