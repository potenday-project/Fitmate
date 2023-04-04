package com.fitmate.dto;

import com.fitmate.entity.Exercise;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class ExerciseDto {

    private Long id;

    private Long planId;

    private Long memberId;

    private String type;

    private String bodyPart;

    private Integer intense;

    private String title;

    private String contents;

    private String doYn;

    private String status;

    private LocalDate planDate;

    private LocalDateTime createTime;

    private LocalDateTime updatedTime;

    private static ModelMapper modelMapper = new ModelMapper();

    public Exercise createExercise() {
        Exercise exercise = new Exercise();
        exercise.setPlanId(getPlanId());
        exercise.setMemberId(getMemberId());
        exercise.setType(getType());
        exercise.setBodyPart(getBodyPart());
        exercise.setIntense(getIntense());
        return exercise;
    }

    public static ExerciseDto of(Exercise exercise) {
        return (ExerciseDto)modelMapper.map(exercise, ExerciseDto.class);
    }
}
