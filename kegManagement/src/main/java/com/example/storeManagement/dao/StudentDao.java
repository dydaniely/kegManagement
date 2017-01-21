package com.example.storeManagement.dao;

import com.example.storeManagement.domain.Student;

import java.util.List;

/**
 * Created by Daniel on 1/10/2017.
 */
public interface StudentDao {
    public void save(Student student);
    public void update(Student student);
    public Student findStudentById(int id) throws RecordNotFoundException;
    public void delete(int id);
    public List<Student> findStudentListByAge(int min, int max) throws RecordNotFoundException;

}
