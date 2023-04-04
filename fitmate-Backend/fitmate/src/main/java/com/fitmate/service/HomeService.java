package com.fitmate.service;

import com.fitmate.constant.PlanType;
import com.fitmate.dto.BodyDto;
import com.fitmate.dto.CommentDto;
import com.fitmate.dto.ExerciseDto;
import com.fitmate.dto.HomeDto;
import com.fitmate.dto.MealDto;
import com.fitmate.dto.PlanDto;
import com.fitmate.entity.Body;
import com.fitmate.entity.Comment;
import com.fitmate.entity.Exercise;
import com.fitmate.entity.Meal;
import com.fitmate.entity.Plan;
import com.fitmate.repository.BodyRepository;
import com.fitmate.repository.CommentRepository;
import com.fitmate.repository.ExerciseRepository;
import com.fitmate.repository.MealRepository;
import com.fitmate.repository.PlanRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class HomeService {

    private final PlanRepository planRepository;
    private final CommentRepository commentRepository;
    private final ExerciseRepository exerciseRepository;
    private final MealRepository mealRepository;
    private final BodyRepository bodyRepository;

    public List<HomeDto> getHomeInfo(Long memberId, LocalDate planDate) {

        List<HomeDto> homeDtoList = new ArrayList<>();
        List<Plan> planList = this.planRepository.findByMemberIdAndPlanDate(memberId, planDate);
        for (Plan plan : planList) {

            HomeDto homeDto = new HomeDto();
            homeDto.setPlanDto(PlanDto.of(plan));

            PlanType planType = plan.getType();
            Long planId = plan.getId();
            if (planType == PlanType.EXERCISE) {
                Optional<Exercise> oExercise = this.exerciseRepository.findByPlanId(planId);
                homeDto.setExerciseDto(ExerciseDto.of(oExercise.get()));

            } else if (planType == PlanType.MEAL) {
                Optional<Meal> oMeal = this.mealRepository.findByPlanId(planId);
                homeDto.setMealDto(MealDto.of(oMeal.get()));

            } else if (planType == PlanType.BODY) {
                Optional<Body> oBody = this.bodyRepository.findByPlanId(planId);
                homeDto.setBodyDto(BodyDto.of(oBody.get()));
            }

            List<Comment> commentList = this.commentRepository.findByPlanId(planId);
            List<CommentDto> commentDtoList = new ArrayList<>();
            for (Comment comment : commentList)
                commentDtoList.add(CommentDto.of(comment));
            homeDtoList.add(homeDto);
        }
        return homeDtoList;
    }
}
