package com.shinhan.mobmail.minji.randomuserwithtdd.domain.usecase

import com.shinhan.mobmail.minji.randomuserwithtdd.domain.DataResult
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.UserRepository
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.Users

class GetUserListUseCaseImpl(
    private val userRepository: UserRepository
): GetUserListUseCase {
    override fun invoke(size: Int): DataResult<Users> {
        return userRepository.getUserList(size)
    }
}