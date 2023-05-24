package hr.donata.eventinnodemo.repository;

import hr.donata.eventinnodemo.entity.Name;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepository extends JpaRepository <Name, Long>  {



}
