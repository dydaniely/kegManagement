package com.example.storeManagement.dao;

import com.example.storeManagement.domain.Student;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daniel on 1/10/2017.
 */
@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    private HibernateTemplate hibernateTemplate;
    @Override
    public void save(Student student) {
        hibernateTemplate.save(student);
    }

    @Override
    public void update(Student student) {
        hibernateTemplate.update(student);
    }

    @Override
    public Student findStudentById(int id) throws RecordNotFoundException{
/*
        Criteria criteria=hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(Student.class)
                .add(Restrictions.eq("id",id));
        Student student=(Student)criteria.uniqueResult();
        return student;*/

        Student student= (Student) hibernateTemplate.findByNamedQuery("from Student",id);

        return student;
    }

    @Override
    public void delete(int id) {


    }

    @Override
    public List<Student> findStudentListByAge(int min, int max) throws RecordNotFoundException{

      /*  Criteria criteria= hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Student.class
        ).add(Restrictions.between("age",min,max));
      List<Student> studentList=(List<Student>) criteria.uniqueResult();
       return studentList;*/

        List<Student> studentList= (List<Student>) hibernateTemplate.findByNamedQuery("from Student where id between",min,max);
        return studentList;
    }
}
