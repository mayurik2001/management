package com.library.management.entity;

import com.library.management.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "members")
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String name;
    @Pattern(regexp = "^[0-9]{10}$")
    @Column(nullable = false,unique = true,length = 10)
    private String mobileNo;
    @Email
    @Column(unique = true)
    private String email;
    @ManyToOne
    @JoinColumn(name = "academic_year_id")
    private AcademicYear academicYear;
    private String className;
    @ManyToOne
    @JoinColumn(name="division_id")
    private Division division;
    private String rollNo;
    @ManyToOne
    @JoinColumn(name = "medium_id")
    private Medium medium;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
    @Column(columnDefinition = "TEXT")
    private String profilePhoto; // Secure cloud URL string destination

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

}

