package hr.donata.eventinnodemo.repository;

import hr.donata.eventinnodemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
