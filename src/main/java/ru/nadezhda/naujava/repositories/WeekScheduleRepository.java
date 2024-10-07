package ru.nadezhda.naujava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nadezhda.naujava.entities.WeekSchedule;

public interface WeekScheduleRepository extends CrudRepository<WeekSchedule, Long> {
}
