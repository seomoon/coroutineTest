package com.shinhan.mobmail.minji.randomuserwithtdd.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.usecase.GetUserListUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val getUserListUseCase: GetUserListUseCase
): ViewModel() {

    fun getUserList() {
        getUserListUseCase(10)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { Log.i("민지", "SUCCESS: $it")},
                { Log.i("민지", "FALSE: $it")}
            ).isDisposed
    }
}