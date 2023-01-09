package de.flozo.GymApp.services;

import de.flozo.GymApp.exceptions.NotFoundException;
import de.flozo.GymApp.model.WorkoutUnit;
import de.flozo.GymApp.repositories.WorkoutUnitRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class WorkoutUnitServiceImpl implements WorkoutUnitService {


    private final WorkoutUnitRepository workoutUnitRepository;

    public WorkoutUnitServiceImpl(WorkoutUnitRepository workoutUnitRepository) {
        this.workoutUnitRepository = workoutUnitRepository;
    }

    @Override
    public Set<WorkoutUnit> findAll() {
        Set<WorkoutUnit> workoutUnits = new HashSet<>();
        workoutUnitRepository.findAll().iterator().forEachRemaining(workoutUnits::add);
        return workoutUnits;
    }

    @Override
    public WorkoutUnit findById(Long id) {
        Optional<WorkoutUnit> workoutUnitOptional = workoutUnitRepository.findById(id);
        if (workoutUnitOptional.isEmpty()) {
            throw new NotFoundException("Workout unit not found! Id value " + id + " not present!");
        }
        return workoutUnitOptional.get();
    }

    @Override
    public WorkoutUnit save(WorkoutUnit workoutUnit) {
        return workoutUnitRepository.save(workoutUnit);
    }

    @Override
    public void delete(WorkoutUnit workoutUnit) {
        workoutUnitRepository.delete(workoutUnit);
    }

    @Override
    public void deleteById(Long id) {
        workoutUnitRepository.deleteById(id);
    }

    @Override
    public List<WorkoutUnit> findAllByOrderByDateDesc() {
        return workoutUnitRepository.findAllByOrderByDateDesc();
    }
}
