package com.shinhan.mobmail.minji.randomuserwithtdd.domain.usecase

import com.shinhan.mobmail.minji.randomuserwithtdd.DataResult
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.UserRepository
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.User
import io.reactivex.Observable

class GetUserListUseCaseImpl(
    private val userRepository: UserRepository
): GetUserListUseCase {
    override fun invoke(length: Int): Observable<DataResult<ArrayList<User>>> {
        return userRepository.getUserList(length)
    }
}