package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.NameDto;

public interface NameService {


    void create(NameDto nameDto);

    void deleteName(Long id);
}
