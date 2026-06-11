package com.library.management.service;

import com.library.management.DTO.DashboardCountDTO;

public interface DashboardService {
    DashboardCountDTO getTodayCount();

    DashboardCountDTO getLast7DaysCount();

    DashboardCountDTO getLast30DaysCount();

    DashboardCountDTO getLast365DaysCount();

    DashboardCountDTO getTotalCount();
}
