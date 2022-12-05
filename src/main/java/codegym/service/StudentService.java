package codegym.service;

import codegym.model.Student;
import codegym.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    IStudentRepo iStudentRepo;
    public List<Student> getAll(){
        return (List<Student>) iStudentRepo.findAll();
    }
    public Student findByid(Long id){
        return iStudentRepo.findById(id).get();
    }
    public Student save(Student student){
        return iStudentRepo.save(student);
    }
}
