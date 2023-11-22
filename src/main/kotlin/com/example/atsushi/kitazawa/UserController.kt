package com.example.atsushi.kitazawa

import com.example.atsushi.kitazawa.model.User
import com.example.atsushi.kitazawa.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class UserController {
    private val repo = UserRepository()

    @GetMapping("/user")
    fun getUsers(): List<User> {
        return repo.getUsers()
    }

    @GetMapping("/user/{id}")
    fun getUser(@PathVariable id: Int): User {
        val u = repo.getUser(id)
        if (u != null) {
            return u
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "user is not fount.ÏÏØ")
        }
    }
}