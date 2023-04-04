package com.fitmate.entity;

import com.fitmate.dto.MealDto;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "meal")
@Getter @Setter
@ToString
@EntityListeners({AuditingEntityListener.class})
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long planId;

    private Long memberId;

    private String mealName;

    private Integer mealCal;

    private Integer carbo;

    private Integer protein;

    private Integer fat;

    public void updateMeal(MealDto mealDto) {
        this.mealName = mealDto.getMealName();
        this.mealCal = mealDto.getMealCal();
        this.carbo = mealDto.getCarbo();
        this.protein = mealDto.getProtein();
        this.fat = mealDto.getFat();
    }
}
