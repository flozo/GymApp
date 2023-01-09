package de.flozo.GymApp.model;

import jakarta.persistence.*;
import lombok.*;

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
    private java.util.Set<Exercise> exercisesPrimaryMuscle;

    @ManyToMany(mappedBy = "secondaryMusclesWorked")
    private java.util.Set<Exercise> exercisesSecondaryMuscle;

}
