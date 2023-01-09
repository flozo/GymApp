package de.flozo.GymApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "exercise_units")
public class ExerciseUnit extends BaseEntity {

    private Exercise exercise;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exerciseUnit")
    private List<Set> sets;

    @ManyToMany(mappedBy = "exerciseUnits")
    private java.util.Set<WorkoutProgram> workoutPrograms;

}
