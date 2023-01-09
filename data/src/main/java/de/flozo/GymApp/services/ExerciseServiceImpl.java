package de.flozo.GymApp.services;

import de.flozo.GymApp.exceptions.NotFoundException;
import de.flozo.GymApp.model.Exercise;
import de.flozo.GymApp.repositories.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Set<Exercise> findAll() {
        Set<Exercise> exercises = new HashSet<>();
        exerciseRepository.findAll().iterator().forEachRemaining(exercises::add);
        return exercises;
    }

    @Override
    public Exercise findById(Long id) {
        Optional<Exercise> exerciseOptional = exerciseRepository.findById(id);
        if (exerciseOptional.isEmpty()) {
            throw new NotFoundException("Exercise not found! Id value " + id + " not present!");
        }
        return exerciseOptional.get();
    }

    @Override
    public Exercise save(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @Override
    public void delete(Exercise exercise) {
        exerciseRepository.delete(exercise);
    }

    @Override
    public void deleteById(Long id) {
        exerciseRepository.deleteById(id);
    }

}
