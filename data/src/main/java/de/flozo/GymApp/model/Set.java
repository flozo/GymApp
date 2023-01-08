package de.flozo.GymApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Set extends BaseEntity {

    private Integer numberOfRepetitions;

    @OneToOne
    @JoinColumn(name = "weight_id")
    private Weight weight;

}
