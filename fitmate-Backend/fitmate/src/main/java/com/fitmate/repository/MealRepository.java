package com.fitmate.repository;

import com.fitmate.entity.Meal;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
    Optional<Meal> findByPlanId(Long paramLong);
}
