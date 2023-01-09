package de.flozo.GymApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "weight_units")
public class WeightUnit extends BaseEntity {

    private String name;
    private String symbol;

}
