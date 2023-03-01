package edu.abani.seqgen.repo

import edu.abani.seqgen.entities.AppUser
import edu.abani.seqgen.entities.UserComposite
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface UserRepo: JpaRepository<AppUser, UserComposite> {
    fun findById(id: Long): Optional<AppUser>
    @Modifying @Query("delete from AppUser u where u.id = ?1")
    fun deleteId(id: Long)
    fun deleteByCode(code: String)
    @Query("select a from AppUser a where a.code = :code")
    fun findByCode(code: String): AppUser
}