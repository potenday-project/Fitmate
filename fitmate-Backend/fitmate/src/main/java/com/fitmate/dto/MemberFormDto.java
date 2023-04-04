package com.fitmate.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class MemberFormDto {
    private String email;

    private String password;

    private String name;

    private Integer beginWeight;

    private String preferExerType;

    private LocalDateTime alarmTime;

}
