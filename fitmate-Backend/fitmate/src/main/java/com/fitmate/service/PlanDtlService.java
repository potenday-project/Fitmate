package com.fitmate.service;

import com.fitmate.dto.BodyDto;
import com.fitmate.dto.ExerciseDto;
import com.fitmate.dto.MealDto;
import com.fitmate.dto.PlanDto;
import com.fitmate.entity.Body;
import com.fitmate.entity.Exercise;
import com.fitmate.entity.Meal;
import com.fitmate.entity.Plan;
import com.fitmate.repository.BodyRepository;
import com.fitmate.repository.ExerciseRepository;
import com.fitmate.repository.MealRepository;
import com.fitmate.repository.PlanRepository;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@RequiredArgsConstructor
public class PlanDtlService {

    private final PlanRepository planRepository;
    private final ExerciseRepository exerciseRepository;
    private final MealRepository mealRepository;
    private final BodyRepository bodyRepository;

    public void saveExercisePlan(ExerciseDto exerciseDto, List<MultipartFile> planImgList) {

        Long planId = exerciseDto.getPlanId();

        PlanDto planDto = new PlanDto();
        planDto.setId(planId);
        planDto.setMemberId(exerciseDto.getMemberId());
        planDto.setTitle(exerciseDto.getTitle());
        planDto.setContents(exerciseDto.getContents());
        planDto.setDoYn(exerciseDto.getDoYn());
        planDto.setStatus(exerciseDto.getStatus());
        Optional<Plan> oPlan = this.planRepository.findById(planId);

        if (oPlan.isPresent()) {
            Plan plan = oPlan.get();
            plan.updatePlan(planDto);
        } else {
            this.planRepository.save(planDto.createPlan());
        }

        Optional<Exercise> oExercise = this.exerciseRepository.findByPlanId(planId);
        if (oExercise.isPresent()) {
            Exercise exercise = oExercise.get();
            exercise.updateExercise(exerciseDto);
        } else {
            this.exerciseRepository.save(exerciseDto.createExercise());
        }
    }

    public void saveMealPlan(MealDto mealDto, List<MultipartFile> planImgList) {

        Long planId = mealDto.getPlanId();

        PlanDto planDto = new PlanDto();
        planDto.setId(planId);
        planDto.setMemberId(mealDto.getMemberId());
        planDto.setTitle(mealDto.getTitle());
        planDto.setContents(mealDto.getContents());
        planDto.setDoYn(mealDto.getDoYn());
        planDto.setStatus(mealDto.getStatus());
        Optional<Plan> oPlan = this.planRepository.findById(planId);

        if (oPlan.isPresent()) {
            Plan plan = oPlan.get();
            plan.updatePlan(planDto);
        } else {
            this.planRepository.save(planDto.createPlan());
        }

        Optional<Meal> oMeal = this.mealRepository.findByPlanId(planId);
        if (oMeal.isPresent()) {
            Meal meal = oMeal.get();
            meal.updateMeal(mealDto);
        } else {
            this.mealRepository.save(mealDto.createMeal());
        }
    }

    public void saveBodyPlan(BodyDto bodyDto, List<MultipartFile> planImgList) {

        Long planId = bodyDto.getPlanId();

        PlanDto planDto = new PlanDto();
        planDto.setId(planId);
        planDto.setMemberId(bodyDto.getMemberId());
        planDto.setTitle(bodyDto.getTitle());
        planDto.setContents(bodyDto.getContents());
        planDto.setDoYn(bodyDto.getDoYn());
        planDto.setStatus(bodyDto.getStatus());
        Optional<Plan> oPlan = this.planRepository.findById(planId);

        if (oPlan.isPresent()) {
            Plan plan = oPlan.get();
            plan.updatePlan(planDto);
        } else {
            this.planRepository.save(planDto.createPlan());
        }

        Optional<Body> oBody = this.bodyRepository.findByPlanId(planId);
        if (oBody.isPresent()) {
            Body body = oBody.get();
            body.updateBody(bodyDto);
        } else {
            this.bodyRepository.save(bodyDto.createBody());
        }
    }
}
