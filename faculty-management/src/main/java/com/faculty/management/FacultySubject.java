package com.faculty.management;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
class FacultySubjectId implements Serializable {


@Column(name = "faculty_id")
private Integer facultyId;

@Column(name = "subject_id")
private Integer subjectId;

public FacultySubjectId() {
}

public FacultySubjectId(Integer facultyId, Integer subjectId) {
    this.facultyId = facultyId;
    this.subjectId = subjectId;
}

public Integer getFacultyId() {
    return facultyId;
}

public Integer getSubjectId() {
    return subjectId;
}

@Override
public boolean equals(Object object) {
    if (this == object) {
        return true;
    }

    if (!(object instanceof FacultySubjectId that)) {
        return false;
    }

    return Objects.equals(facultyId, that.facultyId)
            && Objects.equals(subjectId, that.subjectId);
}

@Override
public int hashCode() {
    return Objects.hash(facultyId, subjectId);
}


}

@Entity
@Table(name = "faculty_subject")
public class FacultySubject {


@EmbeddedId
private FacultySubjectId id;

public FacultySubject() {
}

public FacultySubject(Integer facultyId, Integer subjectId) {
    this.id = new FacultySubjectId(facultyId, subjectId);
}

public FacultySubjectId getId() {
    return id;
}

public void setId(FacultySubjectId id) {
    this.id = id;
}


}
