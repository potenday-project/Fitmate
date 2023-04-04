package com.fitmate.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class HomeDto {

    PlanDto planDto = new PlanDto();

    ExerciseDto exerciseDto = new ExerciseDto();

    MealDto mealDto = new MealDto();

    BodyDto bodyDto = new BodyDto();

    List<CommentDto> commentDtoList = new ArrayList<>();

}
