package hr.donata.eventinnodemo.repository;

import hr.donata.eventinnodemo.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MentorRepository extends JpaRepository <Mentor, Long> {

    void deleteById(Long id);
    Optional<Mentor> findByEmail(String email);
}
