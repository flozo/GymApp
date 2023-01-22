package de.flozo.GymApp.bootstrap;

import de.flozo.GymApp.model.*;
import de.flozo.GymApp.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final BodyPartService bodyPartService;
    private final MuscleService muscleService;
    private final ExerciseService exerciseService;
    private final ExerciseUnitService exerciseUnitService;
    private final WorkoutProgramService workoutProgramService;

    public DataLoader(BodyPartService bodyPartService, MuscleService muscleService, ExerciseService exerciseService, ExerciseUnitService exerciseUnitService, WorkoutProgramService workoutProgramService) {
        this.bodyPartService = bodyPartService;
        this.muscleService = muscleService;
        this.exerciseService = exerciseService;
        this.exerciseUnitService = exerciseUnitService;
        this.workoutProgramService = workoutProgramService;
    }


    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {


        // Define body parts
        System.out.println("Define body parts ...");
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
        System.out.println("... done!");


        // Define muscles
        System.out.println("Define muscles ...");
        Muscle biceps = new Muscle();
        biceps.setScientificName("Biceps brachii");
        biceps.setShortName("Biceps");
        biceps.setBodyPart(arms);

        Muscle brachialis = new Muscle();
        brachialis.setScientificName("Brachialis");
        brachialis.setShortName("Brachialis");
        brachialis.setBodyPart(arms);

        Muscle brachioradialis = new Muscle();
        brachioradialis.setScientificName("Brachioradialis");
        brachioradialis.setShortName("Brachioradialis");
        brachioradialis.setBodyPart(arms);

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
        System.out.println("... done!");


        System.out.println("Add muscles to body parts ...");
        arms.addMuscle(biceps)
                .addMuscle(brachialis)
                .addMuscle(brachioradialis)
                .addMuscle(triceps);
        legs.addMuscle(quads)
                .addMuscle(hamstring1);
        System.out.println("... done!");


        System.out.println("Define exercises ...");
        Exercise bicepsCurls = new Exercise();
        bicepsCurls.setName("Biceps curls");
        bicepsCurls.addPrimaryMuscleWorked(biceps);
        bicepsCurls.addSecondaryMuscleWorked(brachialis)
                .addSecondaryMuscleWorked(brachioradialis);
        System.out.println("... done!");


        System.out.println("Save body parts ...");
        bodyPartService.save(chest);
        bodyPartService.save(back);
        bodyPartService.save(arms);
        bodyPartService.save(legs);
        bodyPartService.save(shoulders);
        bodyPartService.save(abdominals);
        System.out.println("... done!");


        System.out.println("Save muscles ...");
        muscleService.save(biceps);
        muscleService.save(triceps);
        muscleService.save(quads);
        System.out.println("... done!");


        System.out.println("Save exercises ...");
        exerciseService.save(bicepsCurls);
        System.out.println("... done!");


        System.out.println("Define exercise units ...");
        ExerciseUnit exerciseUnit = new ExerciseUnit();
        exerciseUnit.setExercise(bicepsCurls);
        System.out.println("... done!");


        System.out.println("Define workout programs ...");
        WorkoutProgram workoutProgram = new WorkoutProgram();
        workoutProgram.setName("My program");
        System.out.println("... done!");

        workoutProgram.addExerciseUnit(exerciseUnit);
        exerciseUnit.addWorkoutProgram(workoutProgram);

        System.out.println("Save exercise units ...");
        exerciseUnitService.save(exerciseUnit);
        System.out.println("... done!");

        System.out.println("Save workout programs ...");
        workoutProgramService.save(workoutProgram);
        System.out.println("... done!");


    }
}
