
package com.faculty.management;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    boolean existsByFacultyCode(String facultyCode);
    boolean existsByEmail(String email);
}

