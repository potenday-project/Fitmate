package com.fitmate.dto;

import com.fitmate.entity.Meal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class MealDto {
    private Long id;

    private Long planId;

    private Long memberId;

    private String mealName;

    private Integer mealCal;

    private Integer carbo;

    private Integer protein;

    private Integer fat;

    private String title;

    private String contents;

    private String doYn;

    private String status;

    private LocalDate planDate;

    private LocalDateTime createTime;

    private LocalDateTime updatedTime;

    private static ModelMapper modelMapper = new ModelMapper();

    public Meal createMeal() {
        Meal meal = new Meal();
        meal.setPlanId(getPlanId());
        meal.setMemberId(getMemberId());
        meal.setMealName(getMealName());
        meal.setMealCal(getMealCal());
        meal.setCarbo(getCarbo());
        meal.setProtein(getProtein());
        meal.setFat(getFat());
        return meal;
    }

    public static MealDto of(Meal meal) {
        return (MealDto)modelMapper.map(meal, MealDto.class);
    }
}
