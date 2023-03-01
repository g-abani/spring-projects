package edu.abani.seqgen.controller

import edu.abani.seqgen.entities.Tenant
import edu.abani.seqgen.services.TenantService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
@RestController
@RequestMapping("/api/tenant")
class TenantController(val tenantService: TenantService) {

    @GetMapping
    fun getAllUsers(): List<Tenant> = tenantService.getAllTenants()

    @GetMapping("{id}")
    fun getUser(@PathVariable("id") id: Long): Tenant = tenantService.getTenantById( id )

    @PostMapping
    fun createUser(@RequestBody tenant: Tenant): Tenant = tenantService.saveTenant( tenant )

    @DeleteMapping("{id}")
    fun deleteUser(@PathVariable("id") id: Long) = tenantService.deleteTenant( id )

    @DeleteMapping
    fun deleteAll() = tenantService.deleteAll()

    @PutMapping("{id}")
    fun updateUser(@RequestBody tenant: Tenant, @PathVariable("id") id: Long): Tenant =
        tenantService.updateTenant(tenant, id)
}