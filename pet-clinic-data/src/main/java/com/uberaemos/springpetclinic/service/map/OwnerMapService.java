package com.uberaemos.springpetclinic.service.map;

import com.uberaemos.springpetclinic.model.Owner;
import com.uberaemos.springpetclinic.service.OwnerService;
import com.uberaemos.springpetclinic.service.PetService;
import com.uberaemos.springpetclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            if (owner.getPets() != null) {
                owner.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) pet.setPetType(petTypeService.save(pet.getPetType()));
                    else throw new RuntimeException("Pet Type is required");

                    if (pet.getId() == null) {
                        pet.setId(petService.save(pet).getId());
                    }
                });
            }
            return super.save(owner);
        } else return null;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
