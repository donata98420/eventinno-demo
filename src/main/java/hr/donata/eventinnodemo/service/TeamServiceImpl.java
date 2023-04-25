package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.mapper.TeamMapper;
import hr.donata.eventinnodemo.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService{
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public TeamServiceImpl(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }



}
