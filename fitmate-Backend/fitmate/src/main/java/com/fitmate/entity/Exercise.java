package com.fitmate.entity;

import com.fitmate.dto.ExerciseDto;
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
@Table(name = "exercise")
@Getter @Setter
@ToString
@EntityListeners({AuditingEntityListener.class})
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long planId;

    private Long memberId;

    private String type;

    private String bodyPart;

    private Integer intense;

    public void updateExercise(ExerciseDto exerciseDto) {
        this.type = exerciseDto.getType();
        this.bodyPart = exerciseDto.getBodyPart();
        this.intense = exerciseDto.getIntense();
    }
}
