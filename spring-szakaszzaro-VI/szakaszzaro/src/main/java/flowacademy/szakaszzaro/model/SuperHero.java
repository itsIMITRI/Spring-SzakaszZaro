package flowacademy.szakaszzaro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Table
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SuperHero {
    @Id
    private String id;
    private String name;
    @ManyToOne()
    private Team team;
    private Universe universe;
    private boolean hero;
}
