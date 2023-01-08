package de.flozo.GymApp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ExerciseUnit extends BaseEntity {

    private Exercise exercise;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ExerciseUnit")
    private List<Set> sets;


}
