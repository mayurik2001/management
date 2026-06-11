package com.library.management.service.Impl;

import com.library.management.DTO.DashboardCountDTO;
import com.library.management.repo.BookAssignRepository;
import com.library.management.repo.MemberRepository;
import com.library.management.service.DashboardService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final MemberRepository memberRepository;

    private final BookAssignRepository bookAssignRepository;

    public DashboardServiceImpl(
            MemberRepository memberRepository,
            BookAssignRepository bookAssignRepository) {

        this.memberRepository = memberRepository;
        this.bookAssignRepository = bookAssignRepository;
    }

    @Override
    public DashboardCountDTO getTodayCount(){

        LocalDateTime start= LocalDate.now().atStartOfDay();

        LocalDateTime end= LocalDateTime.now();

        return BuildDashboard(start,end);
    }

    @Override
    public  DashboardCountDTO getLast7DaysCount(){

        LocalDateTime start= LocalDateTime.now().minusDays(7);

        LocalDateTime end= LocalDateTime.now();

        return BuildDashboard(start,end);
    }

    @Override
    public DashboardCountDTO getLast30DaysCount(){

        LocalDateTime start= LocalDateTime.now().minusDays(30);

        LocalDateTime end= LocalDateTime.now();

        return BuildDashboard(start,end);
    }

    @Override
    public  DashboardCountDTO getLast365DaysCount(){

        LocalDateTime start= LocalDateTime.now().minusDays(365);

        LocalDateTime end= LocalDateTime.now();

        return BuildDashboard(start,end);
    }

    @Override
    public DashboardCountDTO getTotalCount(){

        long members= memberRepository.count();
        long bookAssigned=bookAssignRepository.count();

        DashboardCountDTO dto=new DashboardCountDTO();
        dto.setMembers(members);
        dto.setBooksAssigned(bookAssigned);
        dto.setCombined(members+bookAssigned);

        return dto;
    }
    private DashboardCountDTO BuildDashboard(LocalDateTime start, LocalDateTime end) {

        long members=memberRepository.countByCreatedAtBetween(start,end);

        long bookAssigned=bookAssignRepository.countByAssignedAtBetween(start,end);

        DashboardCountDTO dto= new DashboardCountDTO();

        dto.setMembers(members);
        dto.setBooksAssigned(bookAssigned);
        dto.setCombined(members+bookAssigned);

        return dto;
    }
}
