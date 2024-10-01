package ru.nadezhda.naujava.processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.nadezhda.naujava.entities.Homework;
import ru.nadezhda.naujava.services.HomeworkService;

@Component
public class CommandProcessor {

    private final HomeworkService homeworkService;

    @Autowired
    public CommandProcessor(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    public void processCommand(String input) {
        String[] cmd = input.split(" ");
        try {
            switch (cmd[0]) {
                case "create" -> {
                    homeworkService.createHomework(Long.valueOf(cmd[1]), cmd[2], Integer.valueOf(cmd[3]));
                    System.out.println("Домашняя работа успешно добавлена...");
                }
                case "readAll" -> {
                    for (Homework homework : homeworkService.findAll()) {
                        System.out.println(homework);
                    }
                }
                case "read" -> {
                    Homework homework = homeworkService.findById(Long.valueOf(cmd[1]));
                    if (homework != null) {
                        System.out.println(homework);
                    } else {
                        System.out.println("Домашняя работа не найдена");
                    }
                }
                case "delete" -> {
                    homeworkService.deleteById(Long.valueOf(cmd[1]));
                    System.out.println("Домашнее задание успешно удалено");
                }
                case "updateMark" -> {
                    homeworkService.updateMark(Long.valueOf(cmd[1]), Integer.valueOf(cmd[2]));
                    System.out.println("Оценка успешно обновлена");
                }


                default -> System.out.println("Введена неизвестная команда...");
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException exception) {
            System.out.println("Введена неизвестная команда...");
        }

    }
}
