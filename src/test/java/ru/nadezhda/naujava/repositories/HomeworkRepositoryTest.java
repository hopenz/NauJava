package ru.nadezhda.naujava.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nadezhda.naujava.entities.Homework;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HomeworkRepositoryTest {

    private final HomeworkRepository homeworkRepository;

    @Autowired
    public HomeworkRepositoryTest(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
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
        List<Homework> homeworks = homeworkRepository.getHomeworksByMarkBetween(3, 5);

        assertThat(homeworks).hasSize(3);
        assertThat(homeworks).extracting(Homework::getDescription)
                .contains("Math Homework", "English Homework", "History Homework");
    }

    @Test
    void testGetHomeworksWithMarkMoreThanThree() {
        List<Homework> homeworks = homeworkRepository.getHomeworksWithMarkMoreThanThree();

        assertThat(homeworks).hasSize(2);
        assertThat(homeworks).extracting(Homework::getDescription)
                .contains("Math Homework", "English Homework");
    }

    @AfterEach
    void deleteAll(){
        homeworkRepository.deleteAll();
    }
}
