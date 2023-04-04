package com.fitmate.dto;

import com.fitmate.constant.Role;
import com.fitmate.entity.Member;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class MemberDto {
    private String email;

    private String name;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    private LocalDateTime leaveTime;

    private Role role;

    private int beginWeight;

    private int level;

    private String preferExerType;

    private LocalDateTime alarmTime;

    private static ModelMapper modelMapper = new ModelMapper();

    public Member createMember() {
        return modelMapper.map(this, Member.class);
    }

    public static MemberDto of(Member member) {
        return modelMapper.map(member, MemberDto.class);
    }
}
