package com.anubhavtyagi28.springmvc.services;

import com.anubhavtyagi28.springmvc.dto.DepartmentDTO;
import com.anubhavtyagi28.springmvc.entities.DepartmentEntity;
import com.anubhavtyagi28.springmvc.exceptions.ResourceNotFoundException;
import com.anubhavtyagi28.springmvc.repositories.DepartmentRepository;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;
    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }
    public Optional<DepartmentDTO> getDepartmentById(Long id) {
        return departmentRepository.findById(id).map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class));
    }
    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities
                .stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());

    }

    public DepartmentDTO createNewDepartment(DepartmentDTO inputDepartment) {
        DepartmentEntity toSaveEntity = modelMapper.map(inputDepartment, DepartmentEntity.class);
        DepartmentEntity savedDepartment = departmentRepository.save(toSaveEntity);
        return modelMapper.map(savedDepartment, DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartmentById(Long id, DepartmentDTO departmentDTO) {
        isExistsByDepartmentId(id);
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        departmentEntity.setId(id);
        DepartmentEntity savedDepartment = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartment, DepartmentDTO.class);
    }

    public boolean deleteDepartmentById(Long id) {
        isExistsByDepartmentId(id);
        departmentRepository.deleteById(id);
        return true;
    }
    public DepartmentDTO updatePartialDepartmentById(Long id, Map<String, Object> updates) {
        isExistsByDepartmentId(id);
        DepartmentEntity departmentEntity = departmentRepository.findById(id).get();
        updates.forEach((field, value) -> {
            Field declaredField = ReflectionUtils.findField(DepartmentEntity.class, field);
            declaredField.setAccessible(true);
            ReflectionUtils.setField(declaredField, departmentEntity, value);
        });
        return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDTO.class);

    }
    public void isExistsByDepartmentId(Long id) {
        boolean exists = departmentRepository.existsById(id);
        if(!exists) throw new ResourceNotFoundException("Department not found with id "+id);
    }
}
