package com.uberaemos.springpetclinic.repository;

import com.uberaemos.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
