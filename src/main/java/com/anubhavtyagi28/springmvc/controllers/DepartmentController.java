package com.anubhavtyagi28.springmvc.controllers;


import com.anubhavtyagi28.springmvc.entities.DepartmentEntity;
import com.anubhavtyagi28.springmvc.repositories.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="departments")
public class DepartmentController {
    private final DepartmentRepository departmentRepository;
    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
   @GetMapping(path = "/{id}")
    public DepartmentEntity getDepartmentById(@PathVariable Long id){
        return departmentRepository.findById(id).orElse(null);
    }
    @GetMapping
    public List<DepartmentEntity> getAllDepartments(@RequestParam(required = false) String title) {
        return departmentRepository.findAll();
    }
    @PostMapping
    public DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity inputDepartmeny){
        return departmentRepository.save(inputDepartmeny);
    }
}
