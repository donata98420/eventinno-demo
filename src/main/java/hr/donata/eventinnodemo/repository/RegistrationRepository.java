package hr.donata.eventinnodemo.repository;

import hr.donata.eventinnodemo.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
