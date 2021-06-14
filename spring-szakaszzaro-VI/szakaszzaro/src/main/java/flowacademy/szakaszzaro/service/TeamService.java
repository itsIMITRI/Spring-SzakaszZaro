package flowacademy.szakaszzaro.service;

import flowacademy.szakaszzaro.exception.ValdationException;
import flowacademy.szakaszzaro.model.SuperHero;
import flowacademy.szakaszzaro.model.Team;
import flowacademy.szakaszzaro.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;


    public void createTeam(Team team) {
        teamRepository.save(Team.builder()
                .id(UUID.randomUUID().toString())
                .name(team.getName())
                .kind(team.getKind())
                .universe(team.getUniverse()).build());
    }

    public List<Team> getAllTeam(){
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(String id){
        return teamRepository.findById(id);
    }

    public Team updateTeam(String id, Team team){
        Optional<Team> update = teamRepository.findById(id);
        Team updatedTeam = update.get();

        updatedTeam.setName(team.getName());
        updatedTeam.setKind(team.getKind());
        updatedTeam.setUniverse(team.getUniverse());
        teamRepository.save(updatedTeam);
        return updatedTeam;
    }

    public void validate(Team team) throws ValdationException {

        if(!StringUtils.hasText(team.getName()) && !StringUtils.hasText(String.valueOf(team.getName() == null))){
            throw new ValdationException("Adj meg nevet!");
        }
        if(team.getKind() == null){
            throw new ValdationException(("Nem lehet a Kind null!"));
        }
        if(team.getUniverse() == null){
            throw new ValdationException("Nem lehet az Universe null");
        }
    }
}
