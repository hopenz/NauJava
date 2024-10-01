package ru.nadezhda.naujava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nadezhda.naujava.entities.Homework;
import ru.nadezhda.naujava.repositories.HomeworkRepository;

import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    private final HomeworkRepository homeworkRepository;

    @Autowired
    public HomeworkServiceImpl(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    @Override
    public void createHomework(Long id, String subject, Integer mark) {
        homeworkRepository.create(new Homework(id, subject, mark));
    }

    @Override
    public List<Homework> findAll() {
        return homeworkRepository.readAll();
    }

    @Override
    public Homework findById(Long id) {
        return homeworkRepository.read(id);
    }

    @Override
    public void deleteById(Long id) {
        homeworkRepository.delete(id);
    }

    @Override
    public void updateMark(Long id, Integer mark) {
        Homework homework = homeworkRepository.read(id);
        if (homework != null) {
            homeworkRepository.update(new Homework(id, homework.getSubject(), mark));
        }
    }
}
