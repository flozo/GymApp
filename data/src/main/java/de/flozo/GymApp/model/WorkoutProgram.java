package de.flozo.GymApp.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class WorkoutProgram extends BaseEntity {

    private String name;
    private List<ExerciseUnit> exerciseUnits;
    private String remarks;

}
