package mk.ukim.finki.mk.pet_store_application.repository;

import mk.ukim.finki.mk.pet_store_application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long userId);

}