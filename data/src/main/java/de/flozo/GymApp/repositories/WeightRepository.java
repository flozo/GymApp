package de.flozo.GymApp.repositories;

import de.flozo.GymApp.model.Weight;
import org.springframework.data.repository.CrudRepository;

public interface WeightRepository extends CrudRepository<Weight, Long> {
    
}
