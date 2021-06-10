package com.shinhan.mobmail.minji.randomuserwithtdd.domain.usecase

import com.shinhan.mobmail.minji.randomuserwithtdd.domain.DataResult
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.Users

interface GetUserListUseCase {
    operator fun invoke(size: Int): DataResult<Users>
}