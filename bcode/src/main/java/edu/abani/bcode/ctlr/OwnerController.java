package edu.abani.bcode.ctlr;

import edu.abani.bcode.entities.Owner;
import edu.abani.bcode.entities.Tenant;
import edu.abani.bcode.service.OwnerService;
import edu.abani.bcode.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apis/owner")
public class OwnerController {

    @Autowired private OwnerService ownerService;
    @GetMapping
    public List<Owner> listTenants(){
        return this.ownerService.getOwners();
    }

    @PostMapping
    public void saveTenant(@RequestBody Owner owner){
        this.ownerService.saveTenant(owner);
    }
}
