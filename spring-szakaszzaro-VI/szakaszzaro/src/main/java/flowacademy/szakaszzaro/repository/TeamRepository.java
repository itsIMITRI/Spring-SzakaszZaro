package flowacademy.szakaszzaro.repository;

import flowacademy.szakaszzaro.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, String> {
}
