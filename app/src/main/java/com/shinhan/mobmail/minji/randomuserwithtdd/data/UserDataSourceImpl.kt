package com.shinhan.mobmail.minji.randomuserwithtdd.data

import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.User
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class UserDataSourceImpl(): UserDataSource {
    override fun getUserList(length: Int): Single<ArrayList<User>> {
        val request = UserApi.buildService(UserEndpoints::class.java)
        val call = request.getUsers(length)

        return Single.create { emitter ->
            call.enqueue(object : Callback<ArrayList<User>> {
                override fun onResponse(call: Call<ArrayList<User>>, response: Response<ArrayList<User>>) {
                    if (response.isSuccessful) {
                        emitter.onSuccess(response.body() ?: arrayListOf<User>())
                        return
                    }
                }

                override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                    emitter.onError(Exception(""))
                    return
                }
            })
        }
    }
}