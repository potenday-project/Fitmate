package com.fitmate.controller;

import com.fitmate.dto.HomeDto;
import com.fitmate.service.HomeService;
import java.time.LocalDate;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping(value="/")
    public List<HomeDto> getHomeInfo(Long memberId, LocalDate planDate) {
        return this.homeService.getHomeInfo(memberId, planDate);
    }
}
