package de.flozo.GymApp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class BodyPart extends BaseEntity {

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "BodyPart")
    private Set<Muscle> muscles;

}
