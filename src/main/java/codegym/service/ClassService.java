package codegym.service;

import codegym.model.ClassRoom;
import codegym.model.Student;
import codegym.repository.IClassRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassService {
    @Autowired
    IClassRoomRepo iClassRoomRepo;

    public List<ClassRoom> getAll(){
        return (List<ClassRoom>) iClassRoomRepo.findAll();
    }
    public ClassRoom getById(Long id ){
        return iClassRoomRepo.findById(id).get();
    }
}
