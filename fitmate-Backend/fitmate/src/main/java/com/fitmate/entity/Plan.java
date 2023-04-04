package com.fitmate.entity;

import com.fitmate.constant.OpenType;
import com.fitmate.constant.PlanType;
import com.fitmate.dto.PlanDto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "plan")
@Getter @Setter
@ToString
@EntityListeners({AuditingEntityListener.class})
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    private PlanType type;

    private String title;

    private String contents;

    private String doYn;

    private String status;

    private OpenType openType;

    private LocalDate planDate;

    @CreatedDate
    private LocalDateTime createdTime;

    @LastModifiedDate
    private LocalDateTime updatedTime;

    public void updatePlan(PlanDto planDto) {
        this.type = planDto.getType();
        this.title = planDto.getTitle();
        this.contents = planDto.getContents();
        this.doYn = planDto.getDoYn();
        this.status = planDto.getStatus();
        this.openType = planDto.getOpenType();
    }
}
