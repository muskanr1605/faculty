package com.faculty.management;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "department_id")
private Integer departmentId;

@Column(name = "department_name", nullable = false, unique = true)
private String departmentName;

@Column(name = "hod_name")
private String hodName;

public Department() {
}

public Integer getDepartmentId() {
    return departmentId;
}

public void setDepartmentId(Integer departmentId) {
    this.departmentId = departmentId;
}

public String getDepartmentName() {
    return departmentName;
}

public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
}

public String getHodName() {
    return hodName;
}

public void setHodName(String hodName) {
    this.hodName = hodName;
}


}
