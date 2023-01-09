package de.flozo.GymApp.services;

import de.flozo.GymApp.model.WorkoutUnit;

import java.util.List;

public interface WorkoutUnitService extends CrudService<WorkoutUnit, Long> {

    List<WorkoutUnit> findAllByOrderByDateDesc();

}
