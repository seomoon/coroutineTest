package com.shinhan.mobmail.minji.randomuserwithtdd.domain.usecase

import com.shinhan.mobmail.minji.randomuserwithtdd.domain.DataResult
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.Users
import io.reactivex.Observable

interface GetUserListUseCase {
    operator fun invoke(size: Int): Observable<DataResult<Users>>
}