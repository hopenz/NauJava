package ru.nadezhda.naujava.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.nadezhda.naujava.entities.Homework;

import java.util.List;

public interface HomeworkRepository extends CrudRepository<Homework,Long> {

    List<Homework> getHomeworksByMarkBetween(Integer min,Integer max);

    @Query("FROM Homework WHERE mark > 3")
    List<Homework> getHomeworksWithMarkMoreThanThree();
}
