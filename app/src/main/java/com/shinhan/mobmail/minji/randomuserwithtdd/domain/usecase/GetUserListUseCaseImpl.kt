package com.shinhan.mobmail.minji.randomuserwithtdd.domain.usecase

import com.shinhan.mobmail.minji.randomuserwithtdd.DataResult
import com.shinhan.mobmail.minji.randomuserwithtdd.data.spec.Users
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.UserRepository
import io.reactivex.Observable

class GetUserListUseCaseImpl(
    private val userRepository: UserRepository
): GetUserListUseCase {
    override fun invoke(length: Int): Observable<DataResult<Users>> {
        return userRepository.getUserList(length)
    }
}