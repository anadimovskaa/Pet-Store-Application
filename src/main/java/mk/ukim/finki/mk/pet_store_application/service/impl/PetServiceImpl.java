package mk.ukim.finki.mk.pet_store_application.service.impl;

import mk.ukim.finki.mk.pet_store_application.model.Pet;
import mk.ukim.finki.mk.pet_store_application.model.User;
import mk.ukim.finki.mk.pet_store_application.model.enumeration.PetType;
import mk.ukim.finki.mk.pet_store_application.repository.PetRepository;
import mk.ukim.finki.mk.pet_store_application.repository.UserRepository;
import mk.ukim.finki.mk.pet_store_application.service.PetService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final UserRepository userRepository;

    public PetServiceImpl(PetRepository petRepository, UserRepository userRepository) {
        this.petRepository = petRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createPets() {
        Random randomPet = new Random();
        String[] petNames = {"Bella", "Max", "Luna", "Charlie", "Lucy", "Milo", "Oliver", "Rocky", "Coco", "Daisy"};
        String[] descriptions = {
                "A playful and energetic pet.",
                "Loves to run and play with toys.",
                "A loyal and friendly companion.",
                "Enjoys cuddles and long naps.",
                "A curious and adventurous pet.",
                "Very calm and enjoys quiet places.",
                "Loves to explore new places.",
                "A bit shy but very affectionate.",
                "Very vocal and loves attention.",
                "A social pet that gets along with everyone."
        };

        for (int i = 0; i < petNames.length; i++) {
            String petName = petNames[randomPet.nextInt(petNames.length)];
            PetType petType = (i % 2 == 0) ? PetType.DOG : PetType.CAT;
            LocalDate petBirthDate = LocalDate.now().minusYears(randomPet.nextInt(5) + 1);
            BigDecimal petPrice = BigDecimal.valueOf(randomPet.nextInt(100) + 1);
            Integer rating = (petType == PetType.DOG) ? randomPet.nextInt(5) + 1 : null;
            String description = descriptions[randomPet.nextInt(descriptions.length)];

            Pet pet = new Pet(petName, petType, description, petBirthDate, petPrice, rating, null);
            petRepository.save(pet);
        }
    }


    @Override
    public List<Pet> listPets() {
        return petRepository.findAll();
    }

    @Override
    public BigDecimal calculatePetPrice(Pet pet) {
        int age = LocalDate.now().getYear() - pet.getPetBirthDate().getYear();
        BigDecimal price;

        if(pet.getPetType() == PetType.DOG) {
            price = new BigDecimal(age +(pet.getRating() != null ? pet.getRating() : 0));
        }
        else{
            price = new BigDecimal(age);
        }
        return price;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found"));
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }


}