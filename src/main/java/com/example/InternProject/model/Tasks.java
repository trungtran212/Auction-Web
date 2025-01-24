package com.example.InternProject.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tasks {
    private Long taskID;
    private String taskName;
    private String taskStatus;
    private String taskDesc;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
