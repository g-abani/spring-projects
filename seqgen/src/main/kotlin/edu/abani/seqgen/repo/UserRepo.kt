package edu.abani.seqgen.repo

import edu.abani.seqgen.entities.AppUser
import org.springframework.data.jpa.repository.JpaRepository
interface UserRepo: JpaRepository<AppUser, Long> {
}