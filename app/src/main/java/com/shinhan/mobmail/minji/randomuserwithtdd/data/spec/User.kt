package com.shinhan.mobmail.minji.randomuserwithtdd.data.spec

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("results")
    val results: ArrayList<User>
)

data class User(
    @SerializedName("id")
    val id: Id,
    @SerializedName("picture")
    val picture: Picture,
    @SerializedName("name")
    val name: Name,
    @SerializedName("dob")
    val age: Age,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("nat")
    val nation: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("cell")
    val cell: String,
    @SerializedName("location")
    val location: Location
)

data class Id(val value: String)
data class Picture(val large: String)
data class Name(val first: String, val last: String)
data class Age(val age: Int)
data class Location(val city: String, val country: String, val coordinates: Coordinates)
data class Coordinates(val latitude: String, val longitude: String)