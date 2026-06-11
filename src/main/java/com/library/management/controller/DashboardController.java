package com.library.management.controller;

import com.library.management.DTO.DashboardCountDTO;
import com.library.management.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lms/dashboar")
public class DashboardController {

    private final DashboardService service;

    public DashboardController(
            DashboardService service) {
        this.service = service;
    }

    @GetMapping("/today")
    public DashboardCountDTO getTodayCount() {

        return service.getTodayCount();
    }

    @GetMapping("/last7days")
    public DashboardCountDTO getLast7DaysCount(){

        return service.getLast7DaysCount();
    }

    @GetMapping("/last-30-days")
    public DashboardCountDTO getLast30DaysCount() {

        return service.getLast30DaysCount();
    }

    @GetMapping("/last-365-days")
    public DashboardCountDTO getLast365DaysCount() {

        return service.getLast365DaysCount();
    }

    @GetMapping("/total")
    public DashboardCountDTO getTotalCount() {

        return service.getTotalCount();
    }


}
