package de.flozo.GymApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "weights")
public class Weight extends BaseEntity {

    private Double numericalValue;

    @OneToOne
    @JoinColumn(name = "weight_unit_id")
    private WeightUnit unit;

}
