package de.flozo.GymApp.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "sets")
public class Set extends BaseEntity {

    private Integer numberOfRepetitions;

    @OneToOne
    @JoinColumn(name = "weight_id")
    private Weight weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_unit_id")
    private ExerciseUnit exerciseUnit;

}
