package codegym.repository;

import codegym.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface IStudentRepo extends PagingAndSortingRepository<Student,Long> {

}
