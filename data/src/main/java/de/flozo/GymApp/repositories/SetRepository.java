package de.flozo.GymApp.repositories;

import de.flozo.GymApp.model.SetOfRepetitions;
import org.springframework.data.repository.CrudRepository;

public interface SetRepository extends CrudRepository<SetOfRepetitions, Long> {

}
