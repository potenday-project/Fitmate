package com.fitmate.controller;

import com.fitmate.dto.CalDto;
import com.fitmate.dto.DailyDto;
import com.fitmate.dto.PlanDto;
import com.fitmate.service.DailyService;
import java.time.LocalDate;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DailyController {

    private final DailyService dailyService;

    @PostMapping(value="/daily")
    public void saveDaily(@RequestParam List<PlanDto> planDtoList, @RequestBody(required = false) CalDto calDto) {
        dailyService.saveDaily(planDtoList, calDto);
    }

    @GetMapping(value="/daily")
    public DailyDto getDailyInfo(Long memberId, LocalDate planDate) {
        return dailyService.getDailyInfo(memberId, planDate);
    }
}
