package hr.donata.eventinnodemo.repository;

import hr.donata.eventinnodemo.entity.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRepository extends JpaRepository<Personal, Long> {


}
