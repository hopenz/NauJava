package ru.nadezhda.naujava.configuration;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import ru.nadezhda.naujava.entities.Homework;

import java.util.ArrayList;
import java.util.List;

public class RepositoryConfig {

    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public List<Homework> homeworkContainer() {
        return new ArrayList<>();
    }
}
