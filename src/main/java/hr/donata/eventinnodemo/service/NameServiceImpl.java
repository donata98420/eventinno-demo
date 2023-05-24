package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.NameDto;
import hr.donata.eventinnodemo.mapper.NameMapper;
import hr.donata.eventinnodemo.repository.NameRepository;
import org.springframework.stereotype.Service;

@Service
public class NameServiceImpl implements NameService {

    private final NameRepository nameRepository;
    private final NameMapper nameMapper;


    public NameServiceImpl(NameRepository nameRepository, NameMapper nameMapper) {
        this.nameRepository = nameRepository;
        this.nameMapper = nameMapper;
    }

    @Override
    public void create(NameDto nameDto) {

    }
    @Override
    public void deleteName(Long id) {

    }
}
