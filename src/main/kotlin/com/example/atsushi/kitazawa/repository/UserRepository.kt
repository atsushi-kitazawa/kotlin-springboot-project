package com.example.atsushi.kitazawa.repository

import com.example.atsushi.kitazawa.model.User
import org.springframework.stereotype.Repository

@Repository
class UserRepository(): IUserRepository {

    private var users: MutableList<User> = mutableListOf()

    init {
        val u1 = User(0, "aaa", 20)
        val u2 = User(1, "bbb", 25)
        val u3 = User(2, "ccc", 40)
        users.add(u1)
        users.add(u2)
        users.add(u3)
    }

    override fun getUsers(): List<User> {
        return users
    }

    override fun getUser(id: Int): User? {
        for (u in users) {
            if (u.id == id) {
                return u
            }
        }
        return null
    }
}