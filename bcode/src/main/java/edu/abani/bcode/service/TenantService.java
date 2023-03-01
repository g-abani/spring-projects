package edu.abani.bcode.service;

import edu.abani.bcode.entities.Tenant;
import edu.abani.bcode.repo.TenantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TenantService {
    @Autowired
    private TenantRepo repo;

    public void saveTenant(Tenant tenant){
        this.repo.save(tenant);
    }

    public List<Tenant> getTenants(){
        return this.repo.findAll();
    }

}
