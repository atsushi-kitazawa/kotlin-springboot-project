package com.example.atsushi.kitazawa.repository

import com.example.atsushi.kitazawa.model.User

interface IUserRepository {
    fun getUsers(): List<User>
    fun getUser(id: Int): User?
}