package com.uberaemos.springpetclinic.repository;

import com.uberaemos.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
