package com.example.storeManagement.services.Student;

import com.example.storeManagement.domain.Student;

/**
 * Created by Daniel on 1/10/2017.
 */

public interface StudentManagement {
    public void Save(Student student);
    public void Update(Student student) throws StudentNotFoundException;
    public Student getStudentById(int id) throws StudentNotFoundException;
    public void delete(int id ) throws StudentNotFoundException;
}
