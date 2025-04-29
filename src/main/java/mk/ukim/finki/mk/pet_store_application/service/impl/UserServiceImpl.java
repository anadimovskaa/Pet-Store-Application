package mk.ukim.finki.mk.pet_store_application.service.impl;

import mk.ukim.finki.mk.pet_store_application.model.HistoryLog;
import mk.ukim.finki.mk.pet_store_application.model.Pet;
import mk.ukim.finki.mk.pet_store_application.model.User;
import mk.ukim.finki.mk.pet_store_application.model.enumeration.PetType;
import mk.ukim.finki.mk.pet_store_application.repository.HistoryLogRepository;
import mk.ukim.finki.mk.pet_store_application.repository.PetRepository;
import mk.ukim.finki.mk.pet_store_application.repository.UserRepository;
import mk.ukim.finki.mk.pet_store_application.service.PetService;
import mk.ukim.finki.mk.pet_store_application.service.UserService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PetRepository petRepository;
    private final PetService petService;
    private final HistoryLogRepository historyLogRepository;

    public UserServiceImpl(UserRepository userRepository, PetRepository petRepository, PetService petService,  HistoryLogRepository historyLogRepository) {
        this.userRepository = userRepository;
        this.petRepository = petRepository;
        this.petService = petService;
        this.historyLogRepository = historyLogRepository;
    }

    @Override
    public void createUsers() {
        Random randomUser = new Random();
        String[] names = {"Ana", "Marija", "Jovana", "Eva" , "Lina" , "Kristijan" , "Stefan" , "Marko" , "Matej" , "Leonid"};

        for(int i  = 0 ; i < names.length ; i++){
            String firstName = names[randomUser.nextInt(names.length)];
            String lastName = names[randomUser.nextInt(names.length)];
            String email = firstName.toLowerCase() + randomUser.nextInt(100) + "@gmail.com";
            BigDecimal budget = new BigDecimal(randomUser.nextInt(100) + 1);

            User user = new User(firstName, lastName, email, budget);
            userRepository.save(user);
        }
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean buyPet(Long userId, Long petId) {
        User user  = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
        Pet pet = petRepository.findById(petId).orElseThrow(()-> new RuntimeException("Pet not found"));

        if(pet.getOwner() != null){
            System.out.println("This pet already has an owner!");
            return false;
        }

        BigDecimal price = petService.calculatePetPrice(pet);

        if(user.getBudget().compareTo(price) < 0){
            System.out.println("You do not have enough money!");
            return false;
        }

        pet.setOwner(user);
        petRepository.save(pet);

        user.setBudget(user.getBudget().subtract(price));
        userRepository.save(user);

        if (pet.getPetType() == PetType.CAT) {
            System.out.println("Meow, cat " + pet.getPetName() + " has owner " + user.getFirstName() + " " + user.getLastName());
        } else {
            System.out.println("Woof, dog " + pet.getPetName() + " has owner " + user.getFirstName() + " " + user.getLastName());
        }

        return true;
    }

    @Override
    public User findById(Long ownerId) {
        Optional<User> user = userRepository.findById(ownerId);
        return user.orElse(null);
    }


    public void executeBuyPetBatch() {
        int successfulPurchases = 0;
        int failedPurchases = 0;

        List<User> users = userRepository.findAll();
        for (User user : users) {
            List<Pet> pets = petRepository.findAll();
            for (Pet pet : pets) {
                boolean result = buyPet(user.getUserId(), pet.getPetId());
                if (result) {
                    successfulPurchases++;
                } else {
                    failedPurchases++;
                }
            }
        }

        HistoryLog historyLog = new HistoryLog(LocalDateTime.now(), successfulPurchases, failedPurchases);
        historyLogRepository.save(historyLog);
    }
}