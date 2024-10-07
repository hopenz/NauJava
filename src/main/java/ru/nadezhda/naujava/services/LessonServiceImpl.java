package ru.nadezhda.naujava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import ru.nadezhda.naujava.entities.Homework;
import ru.nadezhda.naujava.entities.Lesson;
import ru.nadezhda.naujava.repositories.HomeworkRepository;
import ru.nadezhda.naujava.repositories.LessonRepository;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService{

    private final LessonRepository lessonRepository;
    private final HomeworkRepository homeworkRepository;
    private final PlatformTransactionManager transactionManager;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository,
                             HomeworkRepository homeworkRepository,
                             PlatformTransactionManager transactionManager) {
        this.lessonRepository = lessonRepository;
        this.homeworkRepository = homeworkRepository;
        this.transactionManager = transactionManager;
    }

    @Override
    public void deleteLessonWhereTeacher(String teacher) {

        TransactionStatus status = transactionManager.getTransaction(new
                DefaultTransactionDefinition());
        try {
            List<Lesson> lessons = lessonRepository.getLessonsByTeacherName(teacher);
            for (Lesson lesson : lessons){
                Homework homework = lesson.getHomework();
                if (homework != null){
                    homeworkRepository.delete(homework);
                }
                lessonRepository.delete(lesson);
            }

            transactionManager.commit(status);

        }catch (DataAccessException ex){
            transactionManager.rollback(status);
            throw ex;
        }

    }
}
