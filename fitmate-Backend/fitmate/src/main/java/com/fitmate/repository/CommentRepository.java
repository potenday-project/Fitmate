package com.fitmate.repository;

import com.fitmate.entity.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPlanId(Long paramLong);
}
