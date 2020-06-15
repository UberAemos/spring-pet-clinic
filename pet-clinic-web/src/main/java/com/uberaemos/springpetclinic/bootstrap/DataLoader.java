package com.uberaemos.springpetclinic.bootstrap;

import com.uberaemos.springpetclinic.model.*;
import com.uberaemos.springpetclinic.service.*;
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
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      PetService petService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        dog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        cat = petTypeService.save(cat);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        dentistry = specialityService.save(dentistry);

        Speciality cardiology = new Speciality();
        cardiology.setDescription("Cardiology");
        cardiology = specialityService.save(cardiology);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        radiology = specialityService.save(radiology);


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

        Pet fido = new Pet();
        fido.setName("Fido");
        fido.setPetType(dog);
        fido.setOwner(john);
        fido.setBirthDate(LocalDate.now());
        john.getPets().add(fido);
        petService.save(fido);

        Pet felix = new Pet();
        felix.setName("Felix");
        felix.setPetType(cat);
        felix.setOwner(jane);
        felix.setBirthDate(LocalDate.now());
        jane.getPets().add(felix);
        petService.save(felix);

        Visit catVisit = new Visit();
        catVisit.setPet(felix);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Cat Visit");
        visitService.save(catVisit);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vet");
        vet1.setLastName("One");
        vet1.getSpecialities().add(cardiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet");
        vet2.setLastName("Two");
        vet2.getSpecialities().add(radiology);
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
