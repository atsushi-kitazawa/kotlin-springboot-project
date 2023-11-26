package com.example.atsushi.kitazawa.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "USER_INFO")
data class User(
    @Id
    @Column(name = "id")
    var id: Int,
    @Column(name = "name")
    var name: String,
    @Column(name = "age")
    var age: Int) {
}