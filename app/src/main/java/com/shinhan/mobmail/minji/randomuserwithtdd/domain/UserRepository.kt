package com.shinhan.mobmail.minji.randomuserwithtdd.domain

import com.shinhan.mobmail.minji.randomuserwithtdd.DataResult
import com.shinhan.mobmail.minji.randomuserwithtdd.data.spec.Users
import io.reactivex.Observable

interface UserRepository {
    fun getUserList(length: Int): Observable<DataResult<Users>>
}