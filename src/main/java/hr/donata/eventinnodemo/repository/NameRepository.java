package hr.donata.eventinnodemo.repository;

import hr.donata.eventinnodemo.entity.Name;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NameRepository extends JpaRepository <Name, Long>  {

    Optional<Object> findByFirstName(String firstName);

    boolean findByLastName(String lastName);
}
