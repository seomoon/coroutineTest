package com.shinhan.mobmail.minji.randomuserwithtdd.data

import com.shinhan.mobmail.minji.randomuserwithtdd.data.spec.Users
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class UserDataSourceImpl(): UserDataSource {
    override fun getUserList(length: Int): Single<Users> {
        val request = UserApi.buildService(UserEndpoints::class.java)
        val call = request.getUsers(length)

        return Single.create { emitter ->
            call.enqueue(object : Callback<Users> {
                override fun onResponse(call: Call<Users>, response: Response<Users>) {
                    if (response.isSuccessful) {
                        emitter.onSuccess(response.body()!!)
                        return
                    }
                }

                override fun onFailure(call: Call<Users>, t: Throwable) {
                    emitter.onError(Exception("Excepiton in UserDataSourceImpl"))
                    return
                }
            })
        }
    }
}