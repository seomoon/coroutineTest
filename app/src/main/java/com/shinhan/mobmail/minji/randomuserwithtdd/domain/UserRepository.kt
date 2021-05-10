package com.shinhan.mobmail.minji.randomuserwithtdd.domain

import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.Users
import io.reactivex.Observable

interface UserRepository {
    fun getUserList(size: Int): Observable<DataResult<Users>>
}