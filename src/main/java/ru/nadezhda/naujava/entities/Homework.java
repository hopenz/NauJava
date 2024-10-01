package ru.nadezhda.naujava.entities;

/**
 * Тема: Электронный дневник для школьников
 * Система для хранения расписания, домашних заданий и оценок.
 */

public class Homework {

    private Long id;

    private String subject;

    private Integer mark;

    public Homework(Long id, String subject, Integer mark) {
        this.id = id;
        this.subject = subject;
        this.mark = mark;
    }

    public Homework() {
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public Integer getMark() {
        return mark;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", mark=" + mark +
                '}';
    }
}
