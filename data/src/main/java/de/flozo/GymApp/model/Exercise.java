package de.flozo.GymApp.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Exercise extends BaseEntity {

    private String name;
    private Set<Muscle> primaryMusclesWorked;
    private Set<Muscle> secondaryMusclesWorked;



}
