package flowacademy.szakaszzaro.bootstrap;

import com.github.javafaker.Faker;
import flowacademy.szakaszzaro.repository.SuperHeroRepository;
import flowacademy.szakaszzaro.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitDataLoader {
    private final TeamRepository teamRepository;
    private final SuperHeroRepository superHeroRepository;

    @Bean
    public Faker faker() {
        return new Faker(Locale.forLanguageTag("hu-HU"));
    }


    public void run(String... args) throws Exception {
        saveSuperHeroes();
        saveTeams();

    }

    private void saveSuperHeroes() {

    }

    private void saveTeams() {
    }
}
