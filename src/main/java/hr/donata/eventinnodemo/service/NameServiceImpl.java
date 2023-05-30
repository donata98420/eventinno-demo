package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.NameDto;
import hr.donata.eventinnodemo.entity.Name;
import hr.donata.eventinnodemo.mapper.NameMapper;
import hr.donata.eventinnodemo.repository.NameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NameServiceImpl implements NameService {
    private final NameRepository nameRepository;
    private final NameMapper nameMapper;

    @Override
    public void create(NameDto nameDto) {
        if (nameRepository.findByNameOfUser(nameDto.getNameOfUser()).isPresent()) {
            throw new EventServiceImpl.BadRequestException("Sorry, this name already exists. Try with another one.");
        }

        Name name = nameMapper.nameDtoToName(nameDto);
        nameRepository.save(name);
    }
    @Override
    public void deleteName(Long id) {
        nameRepository.deleteById(id);

    }
}
