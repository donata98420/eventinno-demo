package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.repository.TeamRegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamRegistrationServiceImpl implements TeamRegistrationService {
    private final TeamRegistrationRepository teamRepository;


    public TeamRegistrationServiceImpl(TeamRegistrationRepository teamRepository) {
        this.teamRepository = teamRepository;

    }




}
