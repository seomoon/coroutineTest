package com.shinhan.mobmail.minji.randomuserwithtdd.data

import com.shinhan.mobmail.minji.randomuserwithtdd.DataResult
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.UserRepository
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.User
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class UserRepositoryImpl(
    private val userDataSource: UserDataSource
): UserRepository {
    override fun getUserList(length: Int): Observable<DataResult<ArrayList<User>>> {
        return Observable.create { emitter ->
            emitter.onNext(DataResult.Loading)

            userDataSource.getUserList(length).map {
                it
            }
                .subscribeOn(Schedulers.io())
                .doFinally { emitter.onComplete() }
                .subscribe(
                    { emitter.onNext(DataResult.Success(it)) },
                    { emitter.onNext(DataResult.Error(it as Exception)) }
                )

        }
    }
}