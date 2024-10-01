package ru.nadezhda.naujava.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.nadezhda.naujava.processors.CommandProcessor;

import java.util.Scanner;

@Configuration
public class Config {

    private CommandProcessor commandProcessor;

    @Autowired
    public Config(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }


    @Bean
    public CommandLineRunner commandScanner() {
        return args ->
        {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Петрушина Надежда" +
                        "\nЭлектронный дневник для школьников");
                System.out.println("Чтобы добавить дз в базу данных введите: create <id> <subject> <mark>" +
                        "\nЧтобы получить все дз из базы данных введите: readAll" +
                        "\nЧтобы получить дз из базы данных введите: read <id>" +
                        "\nЧтобы обновить оценку введите: updateMark <id> <mark>" +
                        "\nЧтобы удалить дз из базы данных введите: delete <id>");
                System.out.println("Введите команду. 'exit' для выхода.");
                while (true) {
                    System.out.print("> ");
                    String input = scanner.nextLine();
                    if ("exit".equalsIgnoreCase(input.trim())) {
                        System.out.println("Выход из программы...");
                        break;
                    }
                    commandProcessor.processCommand(input);
                }
            }
        };
    }


}
