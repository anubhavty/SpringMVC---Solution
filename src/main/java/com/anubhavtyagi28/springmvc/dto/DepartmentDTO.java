package com.anubhavtyagi28.springmvc.dto;

import com.anubhavtyagi28.springmvc.annotations.PrimeNumberValidation;
import com.anubhavtyagi28.springmvc.annotations.ValidPassword;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;

    @NotBlank(message = "Department title is required")
    @Length(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
    private String title;

    @NotBlank(message = "Department code is required")
    @Pattern(
            regexp = "^[A-Z]{2,10}$",
            message = "Code must be 2–10 uppercase letters"
    )
    private String code;

    @Size(max = 200, message = "Description can have max 200 characters")
    private String description;

    @NotNull(message = "isActive is required")
    @AssertTrue(message = "Department must be active")
    @JsonProperty("isActive")
    private Boolean active;

    @PastOrPresent(message = "createdAt cannot be in the future")
    private LocalDateTime createdAt;

    @PastOrPresent(message = "updatedAt cannot be in the future")
    private LocalDateTime updatedAt;

    @NotNull(message = "maxEmployees is required")
    @Min(value = 1, message = "maxEmployees must be at least 1")
    @Max(value = 500, message = "maxEmployees cannot exceed 500")
    private Integer maxEmployees;

    @PositiveOrZero(message = "currentEmployees cannot be negative")
    private Integer currentEmployees;

    @NotNull(message = "annualBudget is required")
    @DecimalMin(value = "10000.00", message = "annualBudget must be at least 10000")
    @DecimalMax(value = "10000000.00", message = "annualBudget cannot exceed 10000000")
    private BigDecimal annualBudget;

    @DecimalMin(value = "1000.00", message = "monthlyBudget must be at least 1000")
    private BigDecimal monthlyBudget;

//    @Range(min = 1, max = 5, message = "departmentRating must be between 1 and 5")
    @PrimeNumberValidation(message = "Rating must be a prime number")
    private Integer departmentRating;

    @URL(message = "departmentWebsite must be a valid URL")
    private String departmentWebsite;

    @NotBlank(message = "supportEmail is required")
    @Email(message = "supportEmail must be a valid email")
    private String supportEmail;
    @NotNull
    @ValidPassword
    private String password;

    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "contactNumber must be a 10-digit number"
    )
    private String contactNumber;

    @Positive(message = "floorNumber must be positive")
    private Integer floorNumber;

    @NotBlank(message = "buildingName is required")
    private String buildingName;

    @NotBlank(message = "headName is required")
    private String headName;

    @Past(message = "establishedDate must be in the past")
    private LocalDate establishedDate;

    @Future(message = "nextAuditDate must be in the future")
    private LocalDate nextAuditDate;

    @Digits(integer = 8, fraction = 2, message = "creditLimit format is invalid")
    private BigDecimal creditLimit;

    @CreditCardNumber(message = "departmentCardNumber is invalid")
    private String departmentCardNumber;
}
