package de.flozo.GymApp.services;

import de.flozo.GymApp.exceptions.NotFoundException;
import de.flozo.GymApp.model.ExerciseUnit;
import de.flozo.GymApp.repositories.ExerciseUnitRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ExerciseUnitServiceImpl implements ExerciseUnitService {

    private final ExerciseUnitRepository exerciseUnitRepository;

    public ExerciseUnitServiceImpl(ExerciseUnitRepository exerciseUnitRepository) {
        this.exerciseUnitRepository = exerciseUnitRepository;
    }

    @Override
    public Set<ExerciseUnit> findAll() {
        Set<ExerciseUnit> exerciseUnits = new HashSet<>();
        exerciseUnitRepository.findAll().iterator().forEachRemaining(exerciseUnits::add);
        return exerciseUnits;
    }

    @Override
    public ExerciseUnit findById(Long id) {
        Optional<ExerciseUnit> exerciseUnitOptional = exerciseUnitRepository.findById(id);
        if (exerciseUnitOptional.isEmpty()) {
            throw new NotFoundException("Exercise unit not found! Id value " + id + " not present!");
        }
        return exerciseUnitOptional.get();
    }

    @Override
    public ExerciseUnit save(ExerciseUnit exerciseUnit) {
        return exerciseUnitRepository.save(exerciseUnit);
    }

    @Override
    public void delete(ExerciseUnit exerciseUnit) {
        exerciseUnitRepository.delete(exerciseUnit);
    }

    @Override
    public void deleteById(Long id) {
        exerciseUnitRepository.deleteById(id);
    }
}
