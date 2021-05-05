package com.shinhan.mobmail.minji.randomuserwithtdd.domain

import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.Users
import io.reactivex.Observable

interface UserRepository {
    fun getUserList(length: Int): Observable<DataResult<Users>>
}