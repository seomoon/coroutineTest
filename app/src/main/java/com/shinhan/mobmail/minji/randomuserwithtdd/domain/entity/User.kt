package com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity

data class Users(
    val results: ArrayList<User>
)

data class User(
    val name: String = EMPTY_STRING,
    val age: String = EMPTY_STRING,
    val gender: String = EMPTY_STRING,
    val nation: String = EMPTY_STRING,
    val email: String = EMPTY_STRING,
    val phone: String = EMPTY_STRING,
    val cell: String = EMPTY_STRING,
    val profile: String = EMPTY_STRING
) {
    companion object {
        val EMPTY_STRING = ""
    }
}