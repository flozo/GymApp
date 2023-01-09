package de.flozo.GymApp.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "exercises")
public class Exercise extends BaseEntity {

    private String name;

    @ManyToMany
    @JoinTable(name = "exercise_primary_muscles",
    joinColumns = @JoinColumn(name = "exercise_id"),
    inverseJoinColumns = @JoinColumn(name = "muscle_id"))
    private java.util.Set<Muscle> primaryMusclesWorked;

    @ManyToMany
    @JoinTable(name = "exercise_secondary_muscles",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "muscle_id"))
    private java.util.Set<Muscle> secondaryMusclesWorked;


}
