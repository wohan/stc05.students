package main.services;

import main.model.dao.StudentDao;
import main.model.entity.Student;
import main.model.impl.StudentDaoImpl;

import java.util.List;

/**
 * Created by Aleksei Lysov on 19.04.2017.
 */
public class StudentServiceImpl implements StudentService{

    public static StudentDao studentDao = new StudentDaoImpl(DataSourceFactory.getDataSource());

    public List<Student> getAllStudents(){
        return studentDao.findAll();
    }

    public void deleteStudent(int id){
        studentDao.delete(id);
    }

    @Override
    public void insert(Student student) {
        studentDao.insert(student);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }
}
