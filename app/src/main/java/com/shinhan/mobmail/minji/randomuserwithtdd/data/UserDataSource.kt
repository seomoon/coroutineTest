package com.shinhan.mobmail.minji.randomuserwithtdd.data

import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.User
import io.reactivex.Single

interface UserDataSource {
    fun getUserList(size: Int): Single<ArrayList<User>>
}