package de.flozo.GymApp.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ExerciseUnit extends BaseEntity {

    private Exercise exercise;
    private Integer numberOfRepetitions;
    private Integer numberOfSets;

}
