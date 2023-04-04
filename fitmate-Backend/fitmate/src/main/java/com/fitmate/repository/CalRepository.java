package com.fitmate.repository;

import com.fitmate.entity.Cal;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalRepository extends JpaRepository<Cal, Long> {
    Optional<Cal> findByMemberIdAndPlanDate(Long paramLong, LocalDate paramLocalDate);
}
