package com.shinhan.mobmail.minji.randomuserwithtdd.data.datasource

import com.shinhan.mobmail.minji.randomuserwithtdd.data.spec.R_Users
import io.reactivex.Single

interface UserDataSource {
    fun getUserList(size: Int): Single<R_Users>
}