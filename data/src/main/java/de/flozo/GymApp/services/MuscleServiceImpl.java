package de.flozo.GymApp.services;

import de.flozo.GymApp.exceptions.NotFoundException;
import de.flozo.GymApp.model.Muscle;
import de.flozo.GymApp.repositories.MuscleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MuscleServiceImpl implements MuscleService {

    private final MuscleRepository muscleRepository;

    public MuscleServiceImpl(MuscleRepository muscleRepository) {
        this.muscleRepository = muscleRepository;
    }

    @Override
    public Set<Muscle> findAll() {
        Set<Muscle> muscles = new HashSet<>();
        muscleRepository.findAll().iterator().forEachRemaining(muscles::add);
        return muscles;
    }

    @Override
    public Muscle findById(Long id) {
        Optional<Muscle> muscleOptional = muscleRepository.findById(id);
        if (muscleOptional.isEmpty()) {
            throw new NotFoundException("Muscle not found! Id value " + id + " not present!");
        }
        return muscleOptional.get();
    }

    @Override
    public Muscle save(Muscle muscle) {
        return muscleRepository.save(muscle);
    }

    @Override
    public void delete(Muscle muscle) {
        muscleRepository.delete(muscle);
    }

    @Override
    public void deleteById(Long id) {
        muscleRepository.deleteById(id);
    }
}
