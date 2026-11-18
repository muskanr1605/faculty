package com.faculty.management;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultySubjectRepository
        extends JpaRepository<FacultySubject, FacultySubjectId> {
}

