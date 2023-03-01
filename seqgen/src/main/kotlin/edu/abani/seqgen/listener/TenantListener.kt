package edu.abani.seqgen.listener

import edu.abani.seqgen.entities.Tenant
import edu.abani.seqgen.repo.TenantRepo
import edu.abani.seqgen.repo.UserRepo
import jakarta.persistence.EntityListeners
import jakarta.persistence.PrePersist
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TenantListener() {

    @PrePersist
    fun onPersist(tenant: Tenant){
        println(tenant)
    }
}