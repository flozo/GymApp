package de.flozo.GymApp.repositories;

import de.flozo.GymApp.model.Exercise;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

}
