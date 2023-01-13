package de.flozo.GymApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "muscles")
public class Muscle extends BaseEntity {

    private String scientificName;
    private String shortName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "body_part_id")
    private BodyPart bodyPart;


    @ManyToMany(mappedBy = "primaryMusclesWorked")
    private Set<Exercise> exercisesPrimaryMuscle = new HashSet<>();

    @ManyToMany(mappedBy = "secondaryMusclesWorked")
    private Set<Exercise> exercisesSecondaryMuscle = new HashSet<>();


    public Muscle addExercisePrimaryMuscle(Exercise exercise) {
        exercisesPrimaryMuscle.add(exercise);
        if (!exercise.getPrimaryMusclesWorked().contains(this)) {
            exercise.addPrimaryMuscleWorked(this);
        }
        return this;
    }

    public Muscle addExerciseSecondaryMuscle(Exercise exercise) {
        exercisesSecondaryMuscle.add(exercise);
        if (!exercise.getSecondaryMusclesWorked().contains(this)) {
            exercise.addSecondaryMuscleWorked(this);
        }
        return this;
    }

}
