package de.flozo.GymApp.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class WeightUnit extends BaseEntity {

    private String name;
    private String symbol;

}
