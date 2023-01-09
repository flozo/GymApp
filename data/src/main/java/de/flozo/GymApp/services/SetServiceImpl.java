package de.flozo.GymApp.services;

import de.flozo.GymApp.exceptions.NotFoundException;
import de.flozo.GymApp.model.Set;
import de.flozo.GymApp.repositories.SetRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class SetServiceImpl implements SetService {

    private final SetRepository setRepository;

    public SetServiceImpl(SetRepository setRepository) {
        this.setRepository = setRepository;
    }

    @Override
    public java.util.Set<Set> findAll() {
        java.util.Set<Set> sets = new HashSet<>();
        setRepository.findAll().iterator().forEachRemaining(sets::add);
        return sets;
    }

    @Override
    public Set findById(Long id) {
        Optional<Set> setOptional = setRepository.findById(id);
        if (setOptional.isEmpty()) {
            throw new NotFoundException("Set not found! Id value " + id + " not present!");
        }
        return setOptional.get();
    }

    @Override
    public Set save(Set set) {
        return setRepository.save(set);
    }

    @Override
    public void delete(Set set) {
        setRepository.delete(set);
    }

    @Override
    public void deleteById(Long id) {
        setRepository.deleteById(id);
    }
}
