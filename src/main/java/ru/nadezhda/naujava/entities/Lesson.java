package ru.nadezhda.naujava.entities;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalTime;

@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Long id;

    @Column
    private String subject;

    @Column
    private LocalTime startTime;

    @Column
    private LocalTime finishTime;

    @Column
    private String teacherName;

    @ManyToOne
    @JoinColumn
    private DaySchedule daySchedule;

    @OneToOne
    @JoinColumn(name = "homework")
    private Homework homework;

    public Lesson() {
    }

    public Lesson(String subject, LocalTime startTime, LocalTime finishTime, String teacherName, DaySchedule daySchedule, Homework homework) {
        this.subject = subject;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.teacherName = teacherName;
        this.daySchedule = daySchedule;
        this.homework = homework;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalTime finishTime) {
        this.finishTime = finishTime;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    public DaySchedule getDaySchedule() {
        return daySchedule;
    }

    public void setDaySchedule(DaySchedule daySchedule) {
        this.daySchedule = daySchedule;
    }
}
