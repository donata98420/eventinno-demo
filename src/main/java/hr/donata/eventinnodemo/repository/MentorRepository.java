package hr.donata.eventinnodemo.repository;

import hr.donata.eventinnodemo.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository <Mentor, Long> {

    void deleteById(Long id);
}
