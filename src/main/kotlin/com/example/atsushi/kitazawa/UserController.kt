package com.example.atsushi.kitazawa

import com.example.atsushi.kitazawa.model.User
import com.example.atsushi.kitazawa.repository.IUserRepository
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/user")
class UserController(private val repo: IUserRepository) {

    companion object {
        private val logger = LoggerFactory.getLogger(UserController::class.java)
    }
    @GetMapping
    fun getUsers(): List<User> {
        logger.debug("call getUsers")
        return repo.getUsers()
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Int): User {
        logger.debug("call getUser")
        val u = repo.getUser(id)
        if (u != null) {
            return u
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "user is not fount.")
        }
    }

    @PostMapping
    fun addUser(@RequestBody u: User): String {
        logger.debug("call addUser")
        repo.addUser(u)
        return "add user success."
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Int): User {
        logger.debug("call deleteUser")
        val u = repo.getUser(id)
        if (u == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "user is not fount.")
        }
        repo.deleteUser(id)
        return u
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Int, @RequestBody user: User): User {
        logger.debug("call updateUser")
        val u = repo.getUser(id)
        if (u == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "user is not fount.")
        }
        u.name = user.name
        u.age = user.age
        repo.updateUser(u)
        return u
    }
}