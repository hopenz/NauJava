package ru.nadezhda.naujava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nadezhda.naujava.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
