package flowacademy.szakaszzaro.service;

import flowacademy.szakaszzaro.exception.ValdationException;
import flowacademy.szakaszzaro.model.SuperHero;
import flowacademy.szakaszzaro.model.Team;
import flowacademy.szakaszzaro.repository.SuperHeroRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.management.OperatingSystemMXBean;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SuperHeroService {
    private final SuperHeroRepository superHeroRepository;

    public void createSuperHero(SuperHero superHero){
        validate(superHero);
        superHeroRepository.save(SuperHero.builder()
        .id(UUID.randomUUID().toString())
        .name(superHero.getName())
        .team(superHero.getTeam())
        .hero(superHero.isHero()).build());
    }

    public List<SuperHero> getAllHeroes(){
        return superHeroRepository.findAll();
    }

    public Optional<SuperHero> getHeroById(String id){
        return superHeroRepository.findById(id);
    }

    public SuperHero updateSuperHero(String id, SuperHero superHero){
        Optional<SuperHero> updated = superHeroRepository.findById(id);
        SuperHero updatedSuperHero = updated.get();

        updatedSuperHero.setName(superHero.getName());
        updatedSuperHero.setTeam(superHero.getTeam());
        updatedSuperHero.setUniverse(superHero.getUniverse());
        superHeroRepository.save(updatedSuperHero);
        return updatedSuperHero;
    }

    public void validate(SuperHero superHero) throws ValdationException{

        if(!StringUtils.hasText(superHero.getName())){
            throw new ValdationException("Adj meg nevet!");
        }
    }
}
