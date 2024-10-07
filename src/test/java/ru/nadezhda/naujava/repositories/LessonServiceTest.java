package ru.nadezhda.naujava.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nadezhda.naujava.entities.Homework;
import ru.nadezhda.naujava.entities.Lesson;
import ru.nadezhda.naujava.services.LessonServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LessonServiceTest {

    private final LessonServiceImpl lessonService;

    private final LessonRepository lessonRepository;

    private final HomeworkRepository homeworkRepository;

    @Autowired
    public LessonServiceTest(LessonServiceImpl lessonService, LessonRepository lessonRepository,
                             HomeworkRepository homeworkRepository) {
        this.lessonService = lessonService;
        this.lessonRepository = lessonRepository;
        this.homeworkRepository = homeworkRepository;
    }

    @BeforeEach
    void setUp() {
        lessonRepository.deleteAll();
        homeworkRepository.deleteAll();
        Homework homework = new Homework("Math Homework", 4, LocalDate.now());
        homeworkRepository.save(homework);
        lessonRepository.save(new Lesson("Math", LocalTime.now(), LocalTime.now(),
                "Math Teacher", null, homework));
    }

    @Test
    void deleteLessonWhereTeacherTest() {
        assertThat(lessonRepository.getLessonsByTeacherName("Math Teacher")).hasSize(1);
        lessonService.deleteLessonWhereTeacher("Math Teacher");
        assertThat(lessonRepository.getLessonsByTeacherName("Math Teacher")).isEmpty();
        assertThat(homeworkRepository.findAll()).isEmpty();
    }

    @AfterEach
    void deleteAll(){
        lessonRepository.deleteAll();
        homeworkRepository.deleteAll();
    }
}
