package de.flozo.GymApp.services;

import de.flozo.GymApp.model.BodyPart;
import de.flozo.GymApp.repositories.BodyPartRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BodyPartServiceImpl implements BodyPartService {

    private final BodyPartRepository bodyPartRepository;

    public BodyPartServiceImpl(BodyPartRepository bodyPartRepository) {
        this.bodyPartRepository = bodyPartRepository;
    }

    @Override
    public Set<BodyPart> findAll() {
        Set<BodyPart> bodyParts = new HashSet<>();
        bodyPartRepository.findAll().iterator().forEachRemaining(bodyParts::add);
        return bodyParts;
    }

    @Override
    public BodyPart findById(Long id) {
        Optional<BodyPart> bodyPartOptional = bodyPartRepository.findById(id);
        if (bodyPartOptional.isEmpty()) {
//            throw new NotFoundException("Body part not found! Id value " + id + " not present!");
        }
        return bodyPartOptional.get();
    }

    @Override
    public BodyPart save(BodyPart bodyPart) {
        return bodyPartRepository.save(bodyPart);
    }

    @Override
    public void delete(BodyPart bodyPart) {
        bodyPartRepository.delete(bodyPart);

    }

    @Override
    public void deleteById(Long id) {
        bodyPartRepository.deleteById(id);
    }

}
