package com.fitmate.repository;

import com.fitmate.entity.Body;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BodyRepository extends JpaRepository<Body, Long> {
    Optional<Body> findByPlanId(Long paramLong);
}