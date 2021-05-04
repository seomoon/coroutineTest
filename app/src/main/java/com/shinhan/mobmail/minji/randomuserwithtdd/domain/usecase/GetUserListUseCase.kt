package com.shinhan.mobmail.minji.randomuserwithtdd.domain.usecase

import com.shinhan.mobmail.minji.randomuserwithtdd.DataResult
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.User
import io.reactivex.Observable

interface GetUserListUseCase {
    operator fun invoke(length: Int): Observable<DataResult<ArrayList<User>>>
}