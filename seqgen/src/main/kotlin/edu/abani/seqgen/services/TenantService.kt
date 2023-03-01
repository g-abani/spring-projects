package edu.abani.seqgen.services

import edu.abani.seqgen.entities.Tenant
import edu.abani.seqgen.repo.TenantRepo
import org.springframework.stereotype.Component

@Component
class TenantService(val tenantRepo: TenantRepo) {

    fun getAllTenants(): List<Tenant> = tenantRepo.findAll()

    fun getTenantById(id: Long): Tenant = tenantRepo.findById( id ).get()

    fun saveTenant(tenant: Tenant): Tenant = tenantRepo.save( tenant )

    fun deleteTenant(id: Long) = println()

    fun deleteAll() = tenantRepo.deleteAll()

    fun updateTenant(updates: Tenant, id: Long): Tenant {
        val user = tenantRepo.findById(id).orElseThrow()
        user.apply {
            name = updates.name
        }
        return tenantRepo.save(user)
    }

}