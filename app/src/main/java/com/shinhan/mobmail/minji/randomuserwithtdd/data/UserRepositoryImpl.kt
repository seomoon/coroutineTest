package com.shinhan.mobmail.minji.randomuserwithtdd.data

import com.shinhan.mobmail.minji.randomuserwithtdd.data.datasource.UserDataSource
import com.shinhan.mobmail.minji.randomuserwithtdd.data.spec.R_Users
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.DataResult
import com.shinhan.mobmail.minji.randomuserwithtdd.data.spec.mapper.UserMapper
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.UserRepository
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.Users
import java.lang.Exception

class UserRepositoryImpl(
    private val userDataSource: UserDataSource
): UserRepository {
    override fun getUserList(size: Int): DataResult<Users> {
        userDataSource.getUserList(size).let { dataResult ->
            return when (dataResult) {
                is DataResult.Success<R_Users> -> DataResult.Success(UserMapper.mapToEntity(dataResult.data))
                is DataResult.Error -> DataResult.Error(dataResult.exception)
                else -> DataResult.Error(Exception("Excepiton in UserRepositoryImpl"))
            }
        }
    }
}