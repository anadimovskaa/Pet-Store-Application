package mk.ukim.finki.mk.pet_store_application.repository;

import mk.ukim.finki.mk.pet_store_application.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet ,Long > {
    Optional<Pet> findById(Long id);
}