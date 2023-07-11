package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.ManualScoreDto;
import hr.donata.eventinnodemo.entity.ManualScore;
import hr.donata.eventinnodemo.mapper.ManualScoreMapper;
import hr.donata.eventinnodemo.repository.ManualScoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ManualScoreServiceImpl implements ManualScoreService {
    public ManualScoreServiceImpl(ManualScoreRepository manualScoreRepository, ManualScoreMapper manualScoreMapper) {
        this.manualScoreRepository = manualScoreRepository;
        this.manualScoreMapper = manualScoreMapper;
    }

    private final ManualScoreRepository manualScoreRepository;
    private final ManualScoreMapper manualScoreMapper;


    @Override
    public ManualScoreDto create(ManualScoreDto manualScoreDto) {
        ManualScore manualScore = manualScoreMapper.manualScoreDtoToManualScore(manualScoreDto);
        manualScoreRepository.save(manualScore);
        return manualScoreDto;
    }
}








