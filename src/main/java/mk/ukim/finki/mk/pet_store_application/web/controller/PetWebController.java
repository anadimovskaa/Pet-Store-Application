package mk.ukim.finki.mk.pet_store_application.web.controller;

import mk.ukim.finki.mk.pet_store_application.model.Pet;
import mk.ukim.finki.mk.pet_store_application.model.enumeration.PetType;
import mk.ukim.finki.mk.pet_store_application.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.time.LocalDate;

@Controller
@RequestMapping("/pets")
public class PetWebController {

    private final PetService petService;

    public PetWebController(PetService petService) {
        this.petService = petService;
    }


}
