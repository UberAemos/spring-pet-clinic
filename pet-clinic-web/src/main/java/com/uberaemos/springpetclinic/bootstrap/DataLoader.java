package com.uberaemos.springpetclinic.bootstrap;

import com.uberaemos.springpetclinic.model.Owner;
import com.uberaemos.springpetclinic.model.Pet;
import com.uberaemos.springpetclinic.model.PetType;
import com.uberaemos.springpetclinic.model.Vet;
import com.uberaemos.springpetclinic.service.OwnerService;
import com.uberaemos.springpetclinic.service.PetService;
import com.uberaemos.springpetclinic.service.PetTypeService;
import com.uberaemos.springpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        dog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        cat = petTypeService.save(cat);


        Owner john = new Owner();
        john.setFirstName("John");
        john.setLastName("Doe");
        john.setAddress("123 Doeland");
        john.setCity("Johanos");
        john.setTelephone("09009009090");
        john.setPets(new HashSet<>());
        ownerService.save(john);

        Owner jane = new Owner();
        jane.setFirstName("Jane");
        jane.setLastName("Doe");
        jane.setAddress("123 Doeland");
        jane.setCity("Jeanettes");
        jane.setTelephone("09009009090");
        jane.setPets(new HashSet<>());
        ownerService.save(jane);

        Pet someDog = new Pet();
        someDog.setName("Fido");
        someDog.setPetType(dog);
        someDog.setOwner(john);
        someDog.setBirthDate(LocalDate.now());
        john.getPets().add(someDog);
        petService.save(someDog);

        Pet someCat = new Pet();
        someCat.setName("Felix");
        someCat.setPetType(cat);
        someCat.setOwner(jane);
        someCat.setBirthDate(LocalDate.now());
        jane.getPets().add(someCat);
        petService.save(someCat);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vet");
        vet1.setLastName("One");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet");
        vet2.setLastName("Two");
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
