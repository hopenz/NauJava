package ru.nadezhda.naujava.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nadezhda.naujava.dao.HomeworkRepositoryCustomImpl;
import ru.nadezhda.naujava.entities.Homework;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HomeworkRepositoryCustomImplTest {

    private final HomeworkRepository homeworkRepository;

    private final HomeworkRepositoryCustomImpl homeworkRepositoryCustom;

    @Autowired
    public HomeworkRepositoryCustomImplTest(HomeworkRepository homeworkRepository,
                                            HomeworkRepositoryCustomImpl homeworkRepositoryCustom) {
        this.homeworkRepository = homeworkRepository;
        this.homeworkRepositoryCustom = homeworkRepositoryCustom;
    }

    @BeforeEach
    void setUp() {
        homeworkRepository.deleteAll();
        homeworkRepository.save(new Homework("Math Homework", 4, LocalDate.now()));
        homeworkRepository.save(new Homework("Science Homework", 2, LocalDate.now()));
        homeworkRepository.save(new Homework("English Homework", 5, LocalDate.now()));
        homeworkRepository.save(new Homework("History Homework", 3, LocalDate.now()));
    }

    @Test
    void testGetHomeworksByMarkBetween() {
        List<Homework> homeworks = homeworkRepositoryCustom.getHomeworksByMarkBetween(3, 5);

        assertThat(homeworks).hasSize(3);
        assertThat(homeworks).extracting(Homework::getDescription)
                .contains("Math Homework", "English Homework", "History Homework");
    }

    @Test
    void testGetHomeworksWithMarkMoreThanThree() {
        List<Homework> homeworks = homeworkRepositoryCustom.getHomeworksWithMarkMoreThanThree();

        assertThat(homeworks).hasSize(2);
        assertThat(homeworks).extracting(Homework::getDescription)
                .contains("Math Homework", "English Homework");
    }

    @AfterEach
    void deleteAll(){
        homeworkRepository.deleteAll();
    }
}