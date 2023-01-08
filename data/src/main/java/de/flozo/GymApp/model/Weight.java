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
public class Weight extends BaseEntity {

    private Double value;

    @OneToOne
    @JoinColumn(name = "weight_unit_id")
    private WeightUnit unit;

}
