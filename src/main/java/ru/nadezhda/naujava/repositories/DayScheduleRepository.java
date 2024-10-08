package ru.nadezhda.naujava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nadezhda.naujava.entities.DaySchedule;

public interface DayScheduleRepository extends CrudRepository<DaySchedule, Long> {
}
