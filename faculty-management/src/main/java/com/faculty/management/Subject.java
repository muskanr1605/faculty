package com.faculty.management;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "subject_id")
private Integer subjectId;

@Column(name = "subject_code", nullable = false, unique = true)
private String subjectCode;

@Column(name = "subject_name", nullable = false)
private String subjectName;

@Column(nullable = false)
private Integer semester;

@Column(nullable = false)
private Integer credits;

@Column(name = "department_id", nullable = false)
private Integer departmentId;

public Subject() {}

public Integer getSubjectId() { return subjectId; }
public void setSubjectId(Integer subjectId) { this.subjectId = subjectId; }

public String getSubjectCode() { return subjectCode; }
public void setSubjectCode(String subjectCode) { this.subjectCode = subjectCode; }

public String getSubjectName() { return subjectName; }
public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

public Integer getSemester() { return semester; }
public void setSemester(Integer semester) { this.semester = semester; }

public Integer getCredits() { return credits; }
public void setCredits(Integer credits) { this.credits = credits; }

public Integer getDepartmentId() { return departmentId; }
public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }


}
