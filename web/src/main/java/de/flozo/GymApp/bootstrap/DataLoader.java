package de.flozo.GymApp.bootstrap;

import de.flozo.GymApp.model.Muscle;
import de.flozo.GymApp.services.MuscleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final MuscleService muscleService;

    public DataLoader(MuscleService muscleService) {
        this.muscleService = muscleService;
    }


    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {


        Muscle biceps = new Muscle();
        biceps.setScientificName("Biceps brachii");
        biceps.setShortName("Biceps");

        Muscle triceps = new Muscle();
        triceps.setScientificName("Triceps brachii");
        triceps.setShortName("Triceps");


        muscleService.save(biceps);
        muscleService.save(triceps);




    }
}
