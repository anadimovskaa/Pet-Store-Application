package mk.ukim.finki.mk.pet_store_application.web.controller;

import mk.ukim.finki.mk.pet_store_application.model.Pet;
import mk.ukim.finki.mk.pet_store_application.model.User;
import mk.ukim.finki.mk.pet_store_application.model.enumeration.PetType;
import mk.ukim.finki.mk.pet_store_application.service.PetService;
import mk.ukim.finki.mk.pet_store_application.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
@RequestMapping("/pets")
public class PetWebController {

    private final PetService petService;
    private final UserService userService;

    public PetWebController(PetService petService, UserService userService) {
        this.petService = petService;
        this.userService = userService;
    }

    @PostMapping("/add")
    public String addPet(@RequestParam String petName,
                         @RequestParam PetType petType,
                         @RequestParam String description,
                         @RequestParam String petBirthDate,
                         @RequestParam BigDecimal petPrice,
                         @RequestParam Integer rating,
                         @RequestParam Long ownerId) {
        User owner = userService.findById(ownerId);

        Pet pet = new Pet(petName, petType, description, LocalDate.parse(petBirthDate), petPrice, rating, owner);

        petService.save(pet);

        return "redirect:/pets/list";
    }


    @GetMapping("/pets")
    public String listPets(Model model) {
        model.addAttribute("pets", petService.listPets());
        return "listPets";
    }



    @GetMapping("/add")
    public String showAddForm() {
        return "addPetForm";
    }

}
