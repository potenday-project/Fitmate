package com.fitmate.service;

import com.fitmate.dto.CalDto;
import com.fitmate.dto.DailyDto;
import com.fitmate.dto.PlanDto;
import com.fitmate.entity.Cal;
import com.fitmate.entity.Plan;
import com.fitmate.repository.CalRepository;
import com.fitmate.repository.PlanRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DailyService {

    private final PlanRepository planRepository;
    private final CalRepository calRepository;

    public void saveDaily(List<PlanDto> planDtoList, CalDto calDto) {

        for (PlanDto planDto : planDtoList) {
            Optional<Plan> oPlan = this.planRepository.findById(planDto.getId());
            if (oPlan.isPresent()) {
                Plan plan = oPlan.get();
                plan.updatePlan(planDto);
                continue;
            }
            this.planRepository.save(planDto.createPlan());
        }
        LocalDate planDate = calDto.getPlanDate();
        Long memberId = calDto.getMemberId();
        Optional<Cal> oCal = this.calRepository.findByMemberIdAndPlanDate(memberId, planDate);
        if (oCal.isPresent()) {
            Cal cal = oCal.get();
            cal.updateCal(calDto);
        } else {
            this.calRepository.save(calDto.createCal());
        }
    }

    public DailyDto getDailyInfo(Long memberId, LocalDate planDate) {

        DailyDto dailyDto = new DailyDto();
        List<Plan> planList = this.planRepository.findByMemberIdAndPlanDate(memberId, planDate);

        List<PlanDto> planDtoList = new ArrayList<>();
        for (Plan plan : planList) {
            if (plan.getStatus().equals("Y")) planDtoList.add(PlanDto.of(plan));
        }
        dailyDto.setPlanDtoList(planDtoList);

        Optional<Cal> oCal = this.calRepository.findByMemberIdAndPlanDate(memberId, planDate);
        if (oCal.isPresent()) {
            CalDto calDto = CalDto.of(oCal.get());
            dailyDto.setCalDto(calDto);
            dailyDto.setCalDto(calDto);
        }
        return dailyDto;
    }
}
