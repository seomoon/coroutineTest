package com.shinhan.mobmail.minji.randomuserwithtdd.domain

import com.shinhan.mobmail.minji.randomuserwithtdd.DataResult
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.User
import io.reactivex.Observable


interface UserRepository {
    fun getUserList(length: Int): Observable<DataResult<ArrayList<User>>>
}