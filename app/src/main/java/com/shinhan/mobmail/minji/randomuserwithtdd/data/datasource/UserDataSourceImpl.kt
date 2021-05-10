package com.shinhan.mobmail.minji.randomuserwithtdd.data.datasource

import com.shinhan.mobmail.minji.randomuserwithtdd.data.retrofit.UserApi
import com.shinhan.mobmail.minji.randomuserwithtdd.data.retrofit.UserEndpoints
import com.shinhan.mobmail.minji.randomuserwithtdd.data.spec.R_Users
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class UserDataSourceImpl(): UserDataSource {
    override fun getUserList(length: Int): Single<R_Users> {
        val request = UserApi.buildService(UserEndpoints::class.java)
        val call = request.getUsers(length)

        return Single.create { emitter ->
            call.enqueue(object : Callback<R_Users> {
                override fun onResponse(call: Call<R_Users>, response: Response<R_Users>) {
                    if (response.isSuccessful) {
                        emitter.onSuccess(response.body()!!)
                        return
                    }
                }

                override fun onFailure(call: Call<R_Users>, t: Throwable) {
                    emitter.onError(Exception("Excepiton in UserDataSourceImpl"))
                    return
                }
            })
        }
    }
}