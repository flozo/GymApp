package de.flozo.GymApp.services;

import de.flozo.GymApp.exceptions.NotFoundException;
import de.flozo.GymApp.model.WeightUnit;
import de.flozo.GymApp.repositories.WeightUnitRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class WeightUnitServiceImpl implements WeightUnitService {

    private final WeightUnitRepository weightUnitRepository;

    public WeightUnitServiceImpl(WeightUnitRepository weightUnitRepository) {
        this.weightUnitRepository = weightUnitRepository;
    }


    @Override
    public Set<WeightUnit> findAll() {
        Set<WeightUnit> weightUnits = new HashSet<>();
        weightUnitRepository.findAll().iterator().forEachRemaining(weightUnits::add);
        return weightUnits;
    }

    @Override
    public WeightUnit findById(Long id) {
        Optional<WeightUnit> weightUnitOptional = weightUnitRepository.findById(id);
        if (weightUnitOptional.isEmpty()) {
            throw new NotFoundException("Weight unit not found! Id value " + id + " not present!");
        }
        return weightUnitOptional.get();
    }

    @Override
    public WeightUnit save(WeightUnit weightUnit) {
        return weightUnitRepository.save(weightUnit);
    }

    @Override
    public void delete(WeightUnit weightUnit) {
        weightUnitRepository.delete(weightUnit);
    }

    @Override
    public void deleteById(Long id) {
        weightUnitRepository.deleteById(id);
    }
}
