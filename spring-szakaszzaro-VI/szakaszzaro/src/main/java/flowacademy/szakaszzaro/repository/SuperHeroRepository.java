package flowacademy.szakaszzaro.repository;

import flowacademy.szakaszzaro.model.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperHeroRepository extends JpaRepository<SuperHero, String> {
}
