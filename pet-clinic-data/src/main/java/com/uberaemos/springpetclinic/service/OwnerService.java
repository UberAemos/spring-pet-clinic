package com.uberaemos.springpetclinic.service;

import com.uberaemos.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
