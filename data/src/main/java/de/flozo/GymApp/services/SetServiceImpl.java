package de.flozo.GymApp.services;

import de.flozo.GymApp.exceptions.NotFoundException;
import de.flozo.GymApp.model.SetOfRepetitions;
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
    public java.util.Set<SetOfRepetitions> findAll() {
        java.util.Set<SetOfRepetitions> setOfRepetitions = new HashSet<>();
        setRepository.findAll().iterator().forEachRemaining(setOfRepetitions::add);
        return setOfRepetitions;
    }

    @Override
    public SetOfRepetitions findById(Long id) {
        Optional<SetOfRepetitions> setOptional = setRepository.findById(id);
        if (setOptional.isEmpty()) {
            throw new NotFoundException("Set not found! Id value " + id + " not present!");
        }
        return setOptional.get();
    }

    @Override
    public SetOfRepetitions save(SetOfRepetitions setOfRepetitions) {
        return setRepository.save(setOfRepetitions);
    }

    @Override
    public void delete(SetOfRepetitions setOfRepetitions) {
        setRepository.delete(setOfRepetitions);
    }

    @Override
    public void deleteById(Long id) {
        setRepository.deleteById(id);
    }
}
