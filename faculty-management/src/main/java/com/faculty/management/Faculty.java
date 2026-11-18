package com.faculty.management;

import jakarta.persistence.*;

@Entity
@Table(name = "faculty")
public class Faculty {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "faculty_id")
private Integer facultyId;

@Column(name = "faculty_code", nullable = false, unique = true)
private String facultyCode;

@Column(name = "first_name", nullable = false)
private String firstName;

@Column(name = "last_name", nullable = false)
private String lastName;

@Column(name = "email", nullable = false, unique = true)
private String email;

@Column(name = "phone")
private String phone;

@Column(name = "designation")
private String designation;

@Column(name = "qualification")
private String qualification;

@Column(name = "experience")
private Integer experience;

@Column(name = "department_id", nullable = false)
private Integer departmentId;

public Faculty() {
}

public Integer getFacultyId() {
    return facultyId;
}

public void setFacultyId(Integer facultyId) {
    this.facultyId = facultyId;
}

public String getFacultyCode() {
    return facultyCode;
}

public void setFacultyCode(String facultyCode) {
    this.facultyCode = facultyCode;
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getPhone() {
    return phone;
}

public void setPhone(String phone) {
    this.phone = phone;
}

public String getDesignation() {
    return designation;
}

public void setDesignation(String designation) {
    this.designation = designation;
}

public String getQualification() {
    return qualification;
}

public void setQualification(String qualification) {
    this.qualification = qualification;
}

public Integer getExperience() {
    return experience;
}

public void setExperience(Integer experience) {
    this.experience = experience;
}

public Integer getDepartmentId() {
    return departmentId;
}

public void setDepartmentId(Integer departmentId) {
    this.departmentId = departmentId;
}


}
