
package com.faculty.management;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "*")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // Get all departments
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Get department by ID
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Integer id) {
        return departmentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add department
    @PostMapping
    public ResponseEntity<?> addDepartment(@RequestBody Department department) {
        if (department.getDepartmentName() == null
                || department.getDepartmentName().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Department name is required.");
        }

        department.setDepartmentId(null);

        try {
            Department savedDepartment = departmentRepository.save(department);
            return ResponseEntity.ok(savedDepartment);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            return ResponseEntity.badRequest()
                    .body("Department name already exists or violates a database constraint.");
        }
    }

    // Update department
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartment(
            @PathVariable Integer id,
            @RequestBody Department updatedDepartment) {

        if (updatedDepartment.getDepartmentName() == null
                || updatedDepartment.getDepartmentName().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Department name is required.");
        }

        return departmentRepository.findById(id)
                .map(department -> {
                    department.setDepartmentName(
                            updatedDepartment.getDepartmentName().trim());
                    department.setHodName(updatedDepartment.getHodName());

                    try {
                        return ResponseEntity.ok(
                                departmentRepository.save(department));
                    } catch (org.springframework.dao.DataIntegrityViolationException e) {
                        return ResponseEntity.badRequest()
                                .body("Department name already exists.");
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete department
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Integer id) {
        if (!departmentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        try {
            departmentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            return ResponseEntity.badRequest()
                    .body("This department is linked to other records and cannot be deleted.");
        }
    }
}

