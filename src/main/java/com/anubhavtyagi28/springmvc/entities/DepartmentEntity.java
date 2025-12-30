package com.anubhavtyagi28.springmvc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "departments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String code;

    private String description;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Integer maxEmployees;

    private Integer currentEmployees;

    private BigDecimal annualBudget;

    private BigDecimal monthlyBudget;

    private Integer departmentRating;

    private String departmentWebsite;

    private String supportEmail;

    private String contactNumber;

    private Integer floorNumber;

    private String buildingName;

    private String headName;

    private LocalDate establishedDate;

    private LocalDate nextAuditDate;

    private BigDecimal creditLimit;

    private String departmentCardNumber;
}
