package de.flozo.GymApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "workout_programs")
public class WorkoutProgram extends BaseEntity {

    private String name;

    @ManyToMany
    @JoinTable(name = "workout_program_exercise_unit",
            joinColumns = @JoinColumn(name = "workout_program_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_unit_id"))
    private List<ExerciseUnit> exerciseUnits = new ArrayList<>();
    private String remarks;

    public WorkoutProgram addExerciseUnit(ExerciseUnit exerciseUnit) {
        exerciseUnits.add(exerciseUnit);
        if (!exerciseUnit.getWorkoutPrograms().contains(this)) {
            exerciseUnit.addWorkoutProgram(this);
        }
        return this;
    }

}
