package com.example.atsushi.kitazawa.repository

import com.example.atsushi.kitazawa.model.User
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
class UserRepository(@PersistenceContext private val entityManager: EntityManager) : IUserRepository {

    override fun getUsers(): List<User> {
        return entityManager.createQuery("from User", User::class.java).resultList
    }

    override fun getUser(id: Int): User? {
        return entityManager.find(User::class.java, id)
    }

    @Transactional
    override fun addUser(u: User): User {
        entityManager.persist(u)
        return u
    }

    @Transactional
    override fun deleteUser(id: Int): User {
        val u = entityManager.find(User::class.java, id)
        entityManager.remove(u)
        return u
    }

    @Transactional
    override fun updateUser(u: User): User? {
        val exist = entityManager.find(User::class.java, u.id)
        if (exist == null) {
            return null
        }
        entityManager.merge(u)
        return u
    }
}