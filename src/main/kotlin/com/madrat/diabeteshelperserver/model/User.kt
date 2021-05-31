package com.madrat.diabeteshelperserver.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User(
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    var id: Int = 0,

    private var name: String,

    private var email: String
) {
    override fun toString(): String {
        return "User(id=$id, name='$name', email=$email)"
    }
}