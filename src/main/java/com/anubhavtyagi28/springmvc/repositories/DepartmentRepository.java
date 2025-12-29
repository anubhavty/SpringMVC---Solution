package com.anubhavtyagi28.springmvc.repositories;


import com.anubhavtyagi28.springmvc.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
