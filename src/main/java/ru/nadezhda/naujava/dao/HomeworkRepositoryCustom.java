package ru.nadezhda.naujava.dao;

import org.springframework.data.jpa.repository.Query;
import ru.nadezhda.naujava.entities.Homework;

import java.util.List;

public interface HomeworkRepositoryCustom {

    List<Homework> getHomeworksByMarkBetween(Integer min, Integer max);

    List<Homework> getHomeworksWithMarkMoreThanThree();

}
