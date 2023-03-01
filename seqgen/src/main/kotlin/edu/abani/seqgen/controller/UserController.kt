package edu.abani.seqgen.controller

import edu.abani.seqgen.entities.AppUser
import edu.abani.seqgen.services.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
@RestController
@RequestMapping("/api/users")
class UserController(val userService: UserService) {

    @GetMapping
    fun getAllUsers(): List<AppUser> = userService.getAllUsers()

    /*@GetMapping("{id}")
    fun getUser(@PathVariable("id") id: Long): AppUser = userService.getUserById( id )*/

    @GetMapping("{code}")
    fun getUserByCode(@PathVariable("code") code: String): AppUser = userService.getUserByCode(code)

    @PostMapping
    fun createUser(@RequestBody appUser: AppUser): AppUser = userService.saveUser( appUser )

    @DeleteMapping("{id}")
    fun deleteUser(@PathVariable("id") id: String) = userService.deleteByCode( id )

    @DeleteMapping
    fun deleteAll() = userService.deleteAll()

    @PutMapping("{id}")
    fun updateUser(@RequestBody appUser: AppUser, @PathVariable("id") id: Long): AppUser =
        userService.updateUser(appUser, id)
}