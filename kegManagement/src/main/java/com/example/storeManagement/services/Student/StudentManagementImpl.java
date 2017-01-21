package com.example.storeManagement.services.Student;

import com.example.storeManagement.dao.RecordNotFoundException;
import com.example.storeManagement.dao.StudentDao;
import com.example.storeManagement.domain.Student;
import org.springframework.stereotype.Service;

/**
 * Created by Daniel on 1/10/2017.
 */
@Service
public class StudentManagementImpl implements StudentManagement {

    private StudentDao studentDao;
    @Override
    public void Save(Student student) {
        studentDao.save(student);
    }

    @Override
    public void Update(Student student) throws StudentNotFoundException {
    studentDao.update(student);
    }

    @Override
    public Student getStudentById(int id) throws StudentNotFoundException {
        try {
            return studentDao.findStudentById(id);
        } catch (RecordNotFoundException e) {
            throw  new StudentNotFoundException();
        }
    }

    @Override
    public void delete(int id) throws StudentNotFoundException{

    }
}
