package flowacademy.szakaszzaro.controller;

import flowacademy.szakaszzaro.model.Team;
import flowacademy.szakaszzaro.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/teams")
public class TeamController {
    private final TeamService teamService;

    @PostMapping()
    public void createTeam(@RequestBody Team team){
        teamService.createTeam(team);
    }

    @GetMapping()
    public List<Team> getAllTeam(){
        return teamService.getAllTeam();
    }

    @GetMapping("/id")
    public Optional<Team> getTeamById(@PathVariable String id){
        return teamService.getTeamById(id);
    }
    @PutMapping("/update/{id}")
    public Team updateTeam (@PathVariable String id, @RequestBody Team team){
        return teamService.updateTeam(id, team);
    }

}
