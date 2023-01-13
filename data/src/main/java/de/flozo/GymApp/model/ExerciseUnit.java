package de.flozo.GymApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private List<SetOfRepetitions> setOfRepetitions = new ArrayList<>();

    @ManyToMany(mappedBy = "exerciseUnits")
    private Set<WorkoutProgram> workoutPrograms = new HashSet<>();

}
