package de.flozo.GymApp.model;

import jakarta.persistence.*;
import lombok.*;

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
    private Set<Exercise> exercisesPrimaryMuscle;

    @ManyToMany(mappedBy = "secondaryMusclesWorked")
    private Set<Exercise> exercisesSecondaryMuscle;

}
