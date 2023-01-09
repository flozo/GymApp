package de.flozo.GymApp.repositories;

import de.flozo.GymApp.model.WorkoutUnit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkoutUnitRepository extends CrudRepository<WorkoutUnit, Long> {

    List<WorkoutUnit> findAllByOrderByDateDesc();

}
