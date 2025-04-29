package mk.ukim.finki.mk.pet_store_application.web.controller;

import mk.ukim.finki.mk.pet_store_application.model.Pet;
import mk.ukim.finki.mk.pet_store_application.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/create-pets")
    public ResponseEntity<Void> createPets() {
        petService.createPets();
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Pet> listPets() {
        return petService.listPets();
    }


    @GetMapping("/{id}/calculate-price")
    public BigDecimal calculatePetPrice(@PathVariable Long id) {
        Pet pet = petService.findById(id);
        return petService.calculatePetPrice(pet);
    }


}
