package com.fitmate.dto;

import com.fitmate.entity.Cal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class CalDto {

    private Long memberId;

    private Long goalCal;

    private LocalDate planDate;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    private static ModelMapper modelMapper = new ModelMapper();

    public Cal createCal() {
        return modelMapper.map(this, Cal.class);
    }

    public static CalDto of(Cal cal) {
        return modelMapper.map(cal, CalDto.class);
    }
}
