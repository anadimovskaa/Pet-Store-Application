package mk.ukim.finki.mk.pet_store_application.web.controller;

import mk.ukim.finki.mk.pet_store_application.model.User;
import mk.ukim.finki.mk.pet_store_application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<Void> createUsers() {
        userService.createUsers();
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @PostMapping("/{userId}/buy/{petId}")
    public ResponseEntity<Void> buyPet(@PathVariable Long userId, @PathVariable Long petId) {
        if(userService.buyPet(userId, petId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
