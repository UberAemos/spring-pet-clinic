package com.uberaemos.springpetclinic.bootstrap;

import com.uberaemos.springpetclinic.model.Owner;
import com.uberaemos.springpetclinic.model.Vet;
import com.uberaemos.springpetclinic.service.OwnerService;
import com.uberaemos.springpetclinic.service.VetService;
import com.uberaemos.springpetclinic.service.map.OwnerServiceMap;
import com.uberaemos.springpetclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Owner");
        owner1.setLastName("One");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Owner");
        owner2.setLastName("Two");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Vet");
        vet1.setLastName("One");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Vet");
        vet2.setLastName("Two");
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}