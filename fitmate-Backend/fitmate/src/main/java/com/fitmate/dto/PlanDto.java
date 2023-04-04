package com.fitmate.dto;

import com.fitmate.constant.OpenType;
import com.fitmate.constant.PlanType;
import com.fitmate.entity.Plan;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class PlanDto {
    private Long id;

    private Long memberId;

    private PlanType type;

    private String title;

    private String contents;

    private String doYn;

    private String status;

    private OpenType openType;

    private LocalDate planDate;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    private static ModelMapper modelMapper = new ModelMapper();

    public Plan createPlan() {
        return modelMapper.map(this, Plan.class);
    }

    public static PlanDto of(Plan plan) {
        return modelMapper.map(plan, PlanDto.class);
    }
}
