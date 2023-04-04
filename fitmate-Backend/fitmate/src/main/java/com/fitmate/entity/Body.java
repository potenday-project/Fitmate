package com.fitmate.entity;

import com.fitmate.dto.BodyDto;
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
@Table(name = "body")
@Getter @Setter
@ToString
@EntityListeners({AuditingEntityListener.class})
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long planId;

    private Long memberId;

    private Long bmi;

    private Long fat;

    private Long water;

    private Long protein;

    private Long bmr;

    private Long visFat;

    private Long bmd;

    public void updateBody(BodyDto bodyDto) {
        this.bmi = bodyDto.getBmi();
        this.fat = bodyDto.getFat();
        this.water = bodyDto.getWater();
        this.protein = bodyDto.getProtein();
        this.bmr = bodyDto.getBmr();
        this.visFat = bodyDto.getVisFat();
        this.bmd = bodyDto.getBmd();
    }
}
