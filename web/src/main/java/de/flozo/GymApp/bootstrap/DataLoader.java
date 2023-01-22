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
        BodyPart chest = BodyPart.builder()
                .name("Chest")
                .build();
        BodyPart back = BodyPart.builder()
                .name("Back")
                .build();
        BodyPart shoulders = BodyPart.builder()
                .name("Shoulders")
                .build();
        BodyPart abdominals = BodyPart.builder()
                .name("Abdominals")
                .build();
        System.out.println("... done!");



        defineArmMuscles();
        defineLegMuscles();


        System.out.println("Save body parts ...");
        bodyPartService.save(chest);
        bodyPartService.save(back);
        bodyPartService.save(shoulders);
        bodyPartService.save(abdominals);
        System.out.println("... done!");




//        System.out.println("Add muscles to body parts ...");
//        arms.addMuscle(biceps)
//                .addMuscle(brachialis)
//                .addMuscle(brachioradialis)
//                .addMuscle(triceps);
//        legs.addMuscle(quads)
//                .addMuscle(hamstring1);
//        System.out.println("... done!");


        System.out.println("Define exercises ...");
        Exercise bicepsCurls = new Exercise();
        bicepsCurls.setName("Biceps curls");
//        bicepsCurls.addPrimaryMuscleWorked(biceps);
//        bicepsCurls.addSecondaryMuscleWorked(brachialis)
//                .addSecondaryMuscleWorked(brachioradialis);
        System.out.println("... done!");




//        System.out.println("Save muscles ...");
//        muscleService.save(quads);
//        System.out.println("... done!");
//

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

    private void defineLegMuscles() {
        BodyPart legs = BodyPart.builder()
                .name("Legs")
                .build();
        Muscle quads = Muscle.builder()
                .scientificName("Quadriceps femoris")
                .shortName("Quads")
                .bodyPart(legs)
                .build();
        Muscle gastrocnemius = Muscle.builder()
                .scientificName("Gastrocnemius")
                .shortName("Gastrocnemius")
                .bodyPart(legs)
                .build();
        Muscle soleus = Muscle.builder()
                .scientificName("Soleus")
                .shortName("Soleus")
                .bodyPart(legs)
                .build();
        Muscle tibialisAnterior = Muscle.builder()
                .scientificName("Tibialis anterior")
                .shortName("Tibialis anterior")
                .bodyPart(legs)
                .build();
        Muscle hamstring1 = Muscle.builder()
                .scientificName("Biceps femoris")
                .shortName("Biceps femoris")
                .bodyPart(legs)
                .build();
        Muscle hamstring2 = Muscle.builder()
                .scientificName("Semitendinosus")
                .shortName("Semitendinosus")
                .bodyPart(legs)
                .build();

        Muscle hamstring3 = Muscle.builder()
                .scientificName("Semimembranosus")
                .shortName("Semimembranosus")
                .bodyPart(legs)
                .build();
        muscleService.save(quads);
        muscleService.save(gastrocnemius);
        muscleService.save(soleus);
        muscleService.save(tibialisAnterior);
        muscleService.save(hamstring1);
        muscleService.save(hamstring2);
        muscleService.save(hamstring3);
        
        bodyPartService.save(legs);
    }

    private void defineArmMuscles() {
        BodyPart arms = BodyPart.builder()
                .name("Arms")
                .build();
        Muscle biceps = Muscle.builder()
                .scientificName("Biceps brachii")
                .shortName("Biceps")
                .bodyPart(arms)
                .build();
        Muscle brachialis = Muscle.builder()
                .scientificName("Brachialis")
                .shortName("Brachialis")
                .bodyPart(arms)
                .build();
        Muscle brachioradialis = Muscle.builder()
                .scientificName("Brachioradialis")
                .shortName("Brachioradialis")
                .bodyPart(arms)
                .build();
        Muscle triceps = Muscle.builder()
                .scientificName("Triceps brachii")
                .shortName("Triceps")
                .bodyPart(arms)
                .build();
        muscleService.save(biceps);
        muscleService.save(brachialis);
        muscleService.save(brachioradialis);
        muscleService.save(triceps);

        bodyPartService.save(arms);
    }
}
