package com.uberaemos.springpetclinic.service.map;

import com.uberaemos.springpetclinic.model.Visit;
import com.uberaemos.springpetclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("map")
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner() == null
                || visit.getPet().getOwner().getId() == null)
            throw new RuntimeException("Invalid Visit");

        return super.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
