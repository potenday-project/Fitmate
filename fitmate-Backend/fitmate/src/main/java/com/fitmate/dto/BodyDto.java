package com.fitmate.dto;

import com.fitmate.entity.Body;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class BodyDto {
    private Long id;

    private Long planId;

    private Long memberId;

    private Long bmi;

    private Long fat;

    private Long water;

    private Long protein;

    private Long bmr;

    private Long visFat;

    private Long bmd;

    private String title;

    private String contents;

    private String doYn;

    private String status;

    private LocalDate planDate;

    private LocalDateTime createTime;

    private LocalDateTime updatedTime;

    private static ModelMapper modelMapper = new ModelMapper();

    public Body createBody() {
        Body body = new Body();
        body.setPlanId(getPlanId());
        body.setMemberId(getMemberId());
        body.setBmi(getBmi());
        body.setFat(getFat());
        body.setWater(getWater());
        body.setProtein(getProtein());
        body.setBmr(getBmr());
        body.setVisFat(getVisFat());
        body.setBmd(getBmd());
        return body;
    }

    public static BodyDto of(Body body) {
        return modelMapper.map(body, BodyDto.class);
    }
}
