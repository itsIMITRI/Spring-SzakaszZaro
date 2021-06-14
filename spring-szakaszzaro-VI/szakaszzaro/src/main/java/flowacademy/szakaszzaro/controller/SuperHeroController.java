package flowacademy.szakaszzaro.controller;

import flowacademy.szakaszzaro.model.SuperHero;
import flowacademy.szakaszzaro.model.Team;
import flowacademy.szakaszzaro.service.SuperHeroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/super-hero")
public class SuperHeroController {
    private final SuperHeroService superHeroService;

    @PostMapping()
    public void createSuperhero(@RequestBody SuperHero superHero){
        superHeroService.createSuperHero(superHero);
    }

    @GetMapping()
    public List<SuperHero> getAllSuperHero(){
        return superHeroService.getAllHeroes();
    }

    @GetMapping("/{id}")
    public Optional<SuperHero> getSuperHeroById(@PathVariable String id){
        return superHeroService.getHeroById(id);
    }

    @PutMapping("/update/{id}")
    public SuperHero updateSuperHero (@PathVariable String id, @RequestBody SuperHero superHero){
        return superHeroService.updateSuperHero(id, superHero);
    }
}
