package com.shinhan.mobmail.minji.randomuserwithtdd.domain.usecase

import com.shinhan.mobmail.minji.randomuserwithtdd.domain.DataResult
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.UserRepository
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.Users
import io.reactivex.Observable

class GetUserListUseCaseImpl(
    private val userRepository: UserRepository
): GetUserListUseCase {
    override fun invoke(length: Int): Observable<DataResult<Users>> {
        return userRepository.getUserList(length)
    }
}