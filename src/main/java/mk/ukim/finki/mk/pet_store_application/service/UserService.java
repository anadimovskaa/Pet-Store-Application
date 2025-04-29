package mk.ukim.finki.mk.pet_store_application.service;

import mk.ukim.finki.mk.pet_store_application.model.User;

import java.util.List;

public interface UserService {
    void createUsers();
    List<User> listUsers();
    boolean buyPet(Long userId, Long petId);
}