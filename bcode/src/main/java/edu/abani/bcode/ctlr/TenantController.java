package edu.abani.bcode.ctlr;

import edu.abani.bcode.entities.Tenant;
import edu.abani.bcode.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apis/tenant")
public class TenantController {

    @Autowired private TenantService tenantService;
    @GetMapping
    public List<Tenant> listTenants(){
        return this.tenantService.getTenants();
    }

    @PostMapping
    public void saveTenant(@RequestBody Tenant tenant){
        this.tenantService.saveTenant(tenant);
    }
}
