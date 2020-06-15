package com.uberaemos.springpetclinic.repository;

import com.uberaemos.springpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
