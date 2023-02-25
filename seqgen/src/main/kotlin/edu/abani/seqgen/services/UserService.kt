package edu.abani.seqgen.services

import edu.abani.seqgen.entities.AppUser
import edu.abani.seqgen.repo.UserRepo
import org.springframework.stereotype.Component
import java.util.NoSuchElementException

@Component
class UserService(val userRepo: UserRepo) {

    fun getAllUsers(): List<AppUser> = userRepo.findAll();

    fun getUserById(id: Long): AppUser = userRepo.getReferenceById(id)

    fun saveUser(appUser: AppUser): AppUser = userRepo.save(appUser)

    fun deleteUser(id: Long) = userRepo.deleteById( id )

    fun updateUser(updates: AppUser, id: Long): AppUser {
        val user = userRepo.findById(id).orElseThrow()
        user.apply {
            name = updates.name
            phone = updates.phone
            email = updates.email
        }
        return userRepo.save(user)
    }

}