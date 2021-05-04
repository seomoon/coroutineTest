package com.shinhan.mobmail.minji.randomuserwithtdd.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shinhan.mobmail.minji.randomuserwithtdd.data.UserDataSourceImpl
import com.shinhan.mobmail.minji.randomuserwithtdd.data.UserRepositoryImpl
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.usecase.GetUserListUseCase
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.usecase.GetUserListUseCaseImpl

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val getUserListUseCase: GetUserListUseCase
) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        when (modelClass::class.java) {
            MainViewModel::class.java ->
                MainViewModel(getUserListUseCase)

            else ->
                MainViewModel(getUserListUseCase)

        } as T

    companion object {
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance() =
            INSTANCE
                ?: synchronized(ViewModelFactory::class.java) {
                    INSTANCE
                        ?: ViewModelFactory(
                            getUserListUseCase = GetUserListUseCaseImpl(
                                UserRepositoryImpl(
                                    UserDataSourceImpl()
                                )
                            )
                        )
                }
    }


}
