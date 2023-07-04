package hr.donata.eventinnodemo.repository;

import hr.donata.eventinnodemo.entity.ManualScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManualScoreRepository extends JpaRepository<ManualScore, Long> {
}
