package com.shinhan.mobmail.minji.randomuserwithtdd.data.datasource

import com.shinhan.mobmail.minji.randomuserwithtdd.data.retrofit.UserApi
import com.shinhan.mobmail.minji.randomuserwithtdd.data.retrofit.UserEndpoints
import com.shinhan.mobmail.minji.randomuserwithtdd.data.spec.R_Users
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.DataResult
import java.lang.Exception

class UserDataSourceImpl(): UserDataSource {
    override fun getUserList(size: Int): DataResult<R_Users> {
        val request = UserApi.buildService(UserEndpoints::class.java)
        val call = request.getUsers(size)
        try {
            call.execute().apply {
                return if (isSuccessful) {
                    body()?.let {
                        DataResult.Success(it)
                    } ?: DataResult.Error(Exception("Excepiton in UserDataSourceImpl"))
                } else {
                    DataResult.Error(Exception("Excepiton in UserDataSourceImpl"))
                }
            }
        } catch (e: Exception) {
            return DataResult.Error(Exception("Excepiton in UserDataSourceImpl"))
        }
    }
}