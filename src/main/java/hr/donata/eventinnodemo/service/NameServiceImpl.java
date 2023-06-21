package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.NameDto;
import hr.donata.eventinnodemo.entity.Name;
import hr.donata.eventinnodemo.mapper.NameMapper;
import hr.donata.eventinnodemo.repository.NameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NameServiceImpl implements NameService {

    private final NameRepository nameRepository;
    private final NameMapper nameMapper;

    @Override
    public void create(NameDto nameDto) {
        Name name = nameMapper.nameDtoToName(nameDto);
        nameRepository.save(name);
    }

    @Override
    public void deleteName(Long id) {
        Optional<Name> optionalName = nameRepository.findById(id);
        if (optionalName.isPresent()) {
            nameRepository.deleteById(id);
        } else {
            throw new NameNotFoundException("This name does not exist.");
        }
    }

    public static class NameNotFoundException extends RuntimeException {
        public NameNotFoundException(String message) {

            super(message);
        }
    }
}