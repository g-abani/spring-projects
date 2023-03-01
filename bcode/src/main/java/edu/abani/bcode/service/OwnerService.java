package edu.abani.bcode.service;

import edu.abani.bcode.entities.Owner;
import edu.abani.bcode.entities.Tenant;
import edu.abani.bcode.repo.OwnerRepo;
import edu.abani.bcode.repo.TenantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OwnerService {
    @Autowired
    private OwnerRepo repo;

    public void saveTenant(Owner owner){
        this.repo.save(owner);
    }

    public List<Owner> getOwners(){
        return this.repo.findAll();
    }

}
