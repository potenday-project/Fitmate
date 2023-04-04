package com.fitmate.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class DailyDto {

    private List<PlanDto> planDtoList = new ArrayList<>();

    private CalDto calDto;

}
