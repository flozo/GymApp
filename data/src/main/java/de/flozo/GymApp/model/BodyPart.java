package de.flozo.GymApp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "body_parts")
public class BodyPart extends BaseEntity {

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bodyPart")
    private Set<Muscle> muscles = new HashSet<>();

    public BodyPart addMuscle(Muscle muscle) {
        muscles.add(muscle);
        muscle.setBodyPart(this);
        return this;
    }


    public BodyPart removeMuscle(Muscle muscle) {
        muscles.remove(muscle);
        muscle.setBodyPart(null);
        return this;
    }

}
