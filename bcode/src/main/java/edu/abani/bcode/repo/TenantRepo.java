package edu.abani.bcode.repo;

import edu.abani.bcode.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepo extends JpaRepository<Tenant, Long> {
}
