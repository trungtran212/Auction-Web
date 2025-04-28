package com.example.InternProject.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private Long userID;
    private String username;
    private String address;
    private Double balance;
    private String gender;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
