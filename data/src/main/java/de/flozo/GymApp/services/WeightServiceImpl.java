package de.flozo.GymApp.services;

import de.flozo.GymApp.exceptions.NotFoundException;
import de.flozo.GymApp.model.Weight;
import de.flozo.GymApp.repositories.WeightRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class WeightServiceImpl implements WeightService {

    private final WeightRepository weightRepository;

    public WeightServiceImpl(WeightRepository weightRepository) {
        this.weightRepository = weightRepository;
    }

    @Override
    public Set<Weight> findAll() {
        Set<Weight> weights = new HashSet<>();
        weightRepository.findAll().iterator().forEachRemaining(weights::add);
        return weights;
    }

    @Override
    public Weight findById(Long id) {
        Optional<Weight> weightOptional = weightRepository.findById(id);
        if (weightOptional.isEmpty()) {
            throw new NotFoundException("Weight not found! Id value " + id + " not present!");
        }
        return weightOptional.get();
    }

    @Override
    public Weight save(Weight weight) {
        return weightRepository.save(weight);
    }

    @Override
    public void delete(Weight weight) {
        weightRepository.delete(weight);
    }

    @Override
    public void deleteById(Long id) {
        weightRepository.deleteById(id);
    }
}
