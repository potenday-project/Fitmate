package com.fitmate.repository;

import com.fitmate.entity.Plan;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findByMemberIdAndPlanDate(Long paramLong, LocalDate paramLocalDate);
}
