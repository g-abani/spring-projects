package edu.abani.seqgen.repo

import edu.abani.seqgen.entities.AppUser
import edu.abani.seqgen.entities.Tenant
import edu.abani.seqgen.entities.UserComposite
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TenantRepo: JpaRepository<Tenant, Long> {
    //fun findById(id: Long): Optional<Tenant>
}