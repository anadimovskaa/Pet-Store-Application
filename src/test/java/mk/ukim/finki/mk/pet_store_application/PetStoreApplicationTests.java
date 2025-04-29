package mk.ukim.finki.mk.pet_store_application;

import mk.ukim.finki.mk.pet_store_application.service.PetService;
import mk.ukim.finki.mk.pet_store_application.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PetStoreApplicationTests {

    MockMvc mockMvc;

    @Autowired
    PetService petService;

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
    }

}
