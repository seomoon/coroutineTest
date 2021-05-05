package com.shinhan.mobmail.minji.randomuserwithtdd.data.spec.mapper

import com.shinhan.mobmail.minji.randomuserwithtdd.data.spec.R_Users
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.User
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.Users

object UserMapper {
    fun mapToEntity(spec: R_Users): Users {
        val userList = arrayListOf<User>()

        for(user in spec.results){
            userList.add(
                User(
                    name = "${user.name.last} ${user.name.first}",
                    age = user.age.age,
                    gender = user.gender,
                    nation = user.nation,
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