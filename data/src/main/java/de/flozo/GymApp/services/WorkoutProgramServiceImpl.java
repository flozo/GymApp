package de.flozo.GymApp.services;

import de.flozo.GymApp.exceptions.NotFoundException;
import de.flozo.GymApp.model.WorkoutProgram;
import de.flozo.GymApp.repositories.WorkoutProgramRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class WorkoutProgramServiceImpl implements WorkoutProgramService {

    private final WorkoutProgramRepository workoutProgramRepository;

    public WorkoutProgramServiceImpl(WorkoutProgramRepository workoutProgramRepository) {
        this.workoutProgramRepository = workoutProgramRepository;
    }

    @Override
    public Set<WorkoutProgram> findAll() {
        Set<WorkoutProgram> workoutPrograms = new HashSet<>();
        workoutProgramRepository.findAll().iterator().forEachRemaining(workoutPrograms::add);
        return workoutPrograms;
    }

    @Override
    public WorkoutProgram findById(Long id) {
        Optional<WorkoutProgram> workoutProgramOptional = workoutProgramRepository.findById(id);
        if (workoutProgramOptional.isEmpty()) {
            throw new NotFoundException("Workout program not found! Id value " + id + " not present!");
        }
        return workoutProgramOptional.get();
    }

    @Override
    public WorkoutProgram save(WorkoutProgram workoutProgram) {
        return workoutProgramRepository.save(workoutProgram);
    }

    @Override
    public void delete(WorkoutProgram workoutProgram) {
        workoutProgramRepository.delete(workoutProgram);
    }

    @Override
    public void deleteById(Long id) {
        workoutProgramRepository.deleteById(id);
    }
}
