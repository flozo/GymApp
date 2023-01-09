package de.flozo.GymApp.bootstrap;

import de.flozo.GymApp.model.BodyPart;
import de.flozo.GymApp.model.Muscle;
import de.flozo.GymApp.services.BodyPartService;
import de.flozo.GymApp.services.MuscleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final BodyPartService bodyPartService;
    private final MuscleService muscleService;

    public DataLoader(BodyPartService bodyPartService, MuscleService muscleService) {
        this.bodyPartService = bodyPartService;
        this.muscleService = muscleService;
    }


    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {


        BodyPart chest = new BodyPart();
        chest.setName("Chest");
        BodyPart back = new BodyPart();
        back.setName("Back");
        BodyPart arms = new BodyPart();
        arms.setName("Arms");
        BodyPart legs = new BodyPart();
        legs.setName("Legs");
        BodyPart shoulders = new BodyPart();
        shoulders.setName("Shoulders");
        BodyPart abdominals = new BodyPart();
        abdominals.setName("Abdominals");



        Muscle biceps = new Muscle();
        biceps.setScientificName("Biceps brachii");
        biceps.setShortName("Biceps");
        biceps.setBodyPart(arms);

        Muscle triceps = new Muscle();
        triceps.setScientificName("Triceps brachii");
        triceps.setShortName("Triceps");
        triceps.setBodyPart(arms);

        Muscle quads = new Muscle();
        quads.setScientificName("Quadriceps femoris");
        quads.setShortName("Quads");
        quads.setBodyPart(legs);

        Muscle hamstring1 = new Muscle();
        hamstring1.setScientificName("Biceps femoris");
        hamstring1.setShortName("Biceps femoris");
        hamstring1.setBodyPart(legs);


        Set<Muscle> armMuscles = new HashSet<>();
        armMuscles.add(biceps);
        armMuscles.add(triceps);

        arms.setMuscles(armMuscles);

        Set<Muscle> legMuscles = new HashSet<>();
        legMuscles.add(quads);
        legMuscles.add(hamstring1);

        legs.setMuscles(legMuscles);


        bodyPartService.save(chest);
        bodyPartService.save(back);
        bodyPartService.save(arms);
        bodyPartService.save(legs);
        bodyPartService.save(shoulders);
        bodyPartService.save(abdominals);


        muscleService.save(biceps);
        muscleService.save(triceps);
        muscleService.save(quads);




    }
}
