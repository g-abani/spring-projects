package edu.abani.seqgen.services

import edu.abani.seqgen.entities.AppUser
import edu.abani.seqgen.entities.UserComposite
import edu.abani.seqgen.repo.UserRepo
import org.springframework.stereotype.Component

@Component
class UserService(val userRepo: UserRepo) {

    fun getAllUsers(): List<AppUser> = userRepo.findAll();

    fun getUserById(id: Long): AppUser {
        var useComp = UserComposite()
        useComp.id = 1L
        useComp.code = "U00001"

        return userRepo.findById(useComp).get()
    }

    fun getUserByCode(code: String): AppUser = userRepo.findByCode(code)

    fun saveUser(appUser: AppUser): AppUser = userRepo.save( appUser )

    fun deleteUser(id: Long) = userRepo.deleteId(id)

    fun deleteByCode(code: String) = userRepo.deleteByCode(code)

    fun deleteAll() = userRepo.deleteAll()

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