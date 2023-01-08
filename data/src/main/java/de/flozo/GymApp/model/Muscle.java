package de.flozo.GymApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Muscle extends BaseEntity {

    private String scientificName;
    private String shortName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_muscle_group_id")
    private MajorMuscleGroup majorMuscleGroup;


    @ManyToOne
    @JoinColumn(name = "execise_id")
    private Set<Exercise> exercisesPrimaryMuscle;

    @ManyToOne
    @JoinColumn(name = "execise_id")
    private Set<Exercise> exercisesSecondaryMuscle;

}
