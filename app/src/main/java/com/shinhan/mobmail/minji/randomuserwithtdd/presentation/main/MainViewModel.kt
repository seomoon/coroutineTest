package com.shinhan.mobmail.minji.randomuserwithtdd.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.DataResult
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.User
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.usecase.GetUserListUseCase
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val getUserListUseCase: GetUserListUseCase
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _userList = MutableLiveData<ArrayList<User>>()
    val userList: LiveData<ArrayList<User>>
        get() = _userList

    suspend fun getUserList() {
        /** main -> io로 변경 해야하는데 코루틴을 하나 더 생성하면 리소스 낭비가 있다. 이럴 때 컨텍스트 스위칭 withContext */
        //viewModelScope.launch(Dispatchers.IO) {
        withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
            getUserListUseCase(10).let {
                when (it) {
                    is DataResult.Success -> _userList.postValue(it.data.results)
                    else -> _userList.postValue(arrayListOf())
                }
                /** postValue = 백그라운드 스레드에서 LiveData변경원할때 mainLooper로 값보내서 변경하도록*/
            }
        }
    }

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.dispose()
    }
}