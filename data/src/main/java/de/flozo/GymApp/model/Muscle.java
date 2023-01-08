package de.flozo.GymApp.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Muscle extends BaseEntity {

    private String scientificName;
    private String shortName;

}
