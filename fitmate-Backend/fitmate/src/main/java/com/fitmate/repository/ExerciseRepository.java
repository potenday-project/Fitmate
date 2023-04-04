package com.fitmate.repository;

import com.fitmate.entity.Exercise;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Optional<Exercise> findByPlanId(Long paramLong);
}