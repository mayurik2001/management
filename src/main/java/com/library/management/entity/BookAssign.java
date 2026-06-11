package com.library.management.entity;

import com.library.management.enums.BookAssignStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "book_assignments")
@Getter
@Setter
public class BookAssign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "resource_id", nullable = false)
    private Resource resource;

    @Column(nullable = false)
    private LocalDate assignDate;

    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookAssignStatus status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime assignedAt;

    @PrePersist
    protected void onCreate() {

        this.assignedAt = LocalDateTime.now();

        if (this.assignDate == null) {
            this.assignDate = LocalDate.now();
        }

        if (this.status == null) {
            this.status = BookAssignStatus.ACTIVE;
        }
    }
}
