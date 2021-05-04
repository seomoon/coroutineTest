package com.shinhan.mobmail.minji.randomuserwithtdd.data

import com.shinhan.mobmail.minji.randomuserwithtdd.data.spec.Users
import io.reactivex.Single

interface UserDataSource {
    fun getUserList(size: Int): Single<Users>
}