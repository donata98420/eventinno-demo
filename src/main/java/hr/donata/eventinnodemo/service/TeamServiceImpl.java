package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService{
    private final TeamRepository teamRepository;


    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;

    }



}
