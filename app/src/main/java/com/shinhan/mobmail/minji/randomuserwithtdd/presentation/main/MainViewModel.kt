package com.shinhan.mobmail.minji.randomuserwithtdd.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.DataResult
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.User
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.succeeded
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.usecase.GetUserListUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val getUserListUseCase: GetUserListUseCase
): ViewModel() {

    val userList: LiveData<ArrayList<User>> get() = _userList
    private val _userList = MutableLiveData<ArrayList<User>>()

    fun getUserList() {
        getUserListUseCase(10)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    when(it) {
                        is DataResult.Success ->
                            _userList.value = it.data.results
                        else ->
                            _userList.value = arrayListOf()
                    }
                },
                {

                }
            ).isDisposed
    }
}