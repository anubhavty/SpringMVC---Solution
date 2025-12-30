package com.anubhavtyagi28.springmvc.controllers;


import com.anubhavtyagi28.springmvc.dto.DepartmentDTO;
import com.anubhavtyagi28.springmvc.entities.DepartmentEntity;
import com.anubhavtyagi28.springmvc.repositories.DepartmentRepository;
import com.anubhavtyagi28.springmvc.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path="departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
   @GetMapping(path = "/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long id){
       Optional<DepartmentDTO> departmentDTO = departmentService.getDepartmentById(id);
        return departmentDTO.map(departmentDTO1 -> ResponseEntity.ok(departmentDTO1)).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(@RequestParam(required = false) String title) {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }
    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody @Valid DepartmentDTO inputDepartment){
        DepartmentDTO savedDepartment = departmentService.createNewDepartment(inputDepartment);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    @PutMapping(path="/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody @Valid DepartmentDTO departmentDTO, @PathVariable Long id) {
        return ResponseEntity.ok(departmentService.updateDepartmentById(id, departmentDTO));
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable Long id) {
        boolean gotDeleted = departmentService.deleteDepartmentById(id);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }
    @PatchMapping(path="/{id}")
    public ResponseEntity<DepartmentDTO> updatePartialEmployeeById(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
        DepartmentDTO departmentDTO = departmentService.updatePartialDepartmentById(id, updates);
        if(departmentDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(departmentDTO);
    }
}
