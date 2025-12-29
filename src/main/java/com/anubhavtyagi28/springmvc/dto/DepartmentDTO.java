package com.anubhavtyagi28.springmvc.dto;

import java.time.LocalDateTime;

public class DepartmentDTO {
    private Long id;
    private String title;
    private Boolean isActive;
    private LocalDateTime createdAt;

    public DepartmentDTO() {

    }

    public DepartmentDTO(Long id, String title, Boolean isActive, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
