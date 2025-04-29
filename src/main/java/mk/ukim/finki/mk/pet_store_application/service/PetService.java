package mk.ukim.finki.mk.pet_store_application.service;

import mk.ukim.finki.mk.pet_store_application.model.Pet;

import java.math.BigDecimal;
import java.util.List;

public interface PetService {
    void createPets();
    List<Pet> listPets();
    BigDecimal calculatePetPrice(Pet pet);
    Pet findById(Long id);

    Pet save(Pet pet);

}
