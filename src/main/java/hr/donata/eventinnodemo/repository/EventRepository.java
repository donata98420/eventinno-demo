package hr.donata.eventinnodemo.repository;

import hr.donata.eventinnodemo.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EventRepository extends JpaRepository <Event, Long> {
    Optional<Event> findByName(String name);
}
