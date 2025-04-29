package mk.ukim.finki.mk.pet_store_application.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mk.ukim.finki.mk.pet_store_application.model.enumeration.PetType;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;

    private String petName;

    @Enumerated(EnumType.STRING)
    private PetType petType;

    private String description;

    private LocalDate petBirthDate;

    private BigDecimal petPrice;

    private Integer rating;

    @ManyToOne
    private User owner;

    public Pet(String petName, PetType petType, String description, LocalDate petBirthDate, BigDecimal petPrice, Integer rating, User owner) {
        this.petName = petName;
        this.petType = petType;
        this.description = description;
        this.petBirthDate = petBirthDate;
        this.petPrice = petPrice;
        this.rating = rating;
        this.owner = owner;
    }


    public Pet(String petName, PetType petType, String description, LocalDate petBirthDate, BigDecimal petPrice, Integer rating, Object owner) {
    }

    private LocalDate birthDate; // or Date birthDate

    public LocalDate getPetBirthDate() {
        return birthDate;
    }

    public PetType getPetType(){
        return petType;
    }

    public Integer getRating() {
        return rating;
    }

    public String getPetName() {
        return petName;
    }

    public Long getPetId() {
        return petId;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPetPrice() {
        return petPrice;
    }

    public User getOwner() {
        return owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setPetPrice(BigDecimal petPrice) {
        this.petPrice = petPrice;
    }


}
