package com.shinhan.mobmail.minji.randomuserwithtdd.data.spec.mapper

import com.shinhan.mobmail.minji.randomuserwithtdd.data.spec.R_Users
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.User
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.Users

object UserMapper {
    fun mapToEntity(spec: R_Users): Users {
        val userList = arrayListOf<User>()

        for (user in spec.results) {
            userList.add(
                User(
                    name = "${user.name.last} ${user.name.first}",
                    age = "(${user.age.age})",
                    gender = when (user.gender) {
                        "male" -> "\uD83D\uDE4B\u200D\u2642\uFE0F"
                        else -> "\uD83D\uDE4B\u200D\u2640\uFE0F"
                    },
                    nation = when (user.nation) {
                        "AU" -> "\uD83C\uDDE6\uD83C\uDDFA"
                        "BR" -> "\uD83C\uDDE7\uD83C\uDDF7"
                        "CA" -> "\uD83C\uDDE8\uD83C\uDDE6"
                        "CH" -> "\uD83C\uDDE8\uD83C\uDDED"
                        "DE" -> "\uD83C\uDDE9\uD83C\uDDEA"
                        "DK" -> "\uD83C\uDDE9\uD83C\uDDF0"
                        "ES" -> "\uD83C\uDDEA\uD83C\uDDF8"
                        "FI" -> "\uD83C\uDDEB\uD83C\uDDEE"
                        "FR" -> "\uD83C\uDDEB\uD83C\uDDF7"
                        "GB" -> "\uD83C\uDDEC\uD83C\uDDE7"
                        "IE" -> "\uD83C\uDDEE\uD83C\uDDEA"
                        "IR" -> "\uD83C\uDDEE\uD83C\uDDF7"
                        "NO" -> "\uD83C\uDDF3\uD83C\uDDF4"
                        "NL" -> "\uD83C\uDDF3\uD83C\uDDF1"
                        "NZ" -> "\uD83C\uDDF3\uD83C\uDDFF"
                        "TR" -> "\uD83C\uDDF9\uD83C\uDDF7"
                        "US" -> "\uD83C\uDDFA\uD83C\uDDF8"
                        else -> "\uD83C\uDDFA\uD83C\uDDF8"
                    },
                    email = user.email,
                    phone = user.phone,
                    cell = user.cell,
                    profile = user.picture.large
                )
            )
        }

        return Users(userList)
    }
}