package com.shinhan.mobmail.minji.randomuserwithtdd

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.DataResult
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.UserRepository
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.Users
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.usecase.GetUserListUseCaseImpl
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetUserListCaseTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule() // LiveData에 Scheduler 제공

    private lateinit var getUserListUseCase: GetUserListUseCaseImpl

    @Mock
    private lateinit var userRepository: UserRepository

    @Before
    fun set(){
        MockitoAnnotations.initMocks(this)

        getUserListUseCase = GetUserListUseCaseImpl(userRepository)

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() } // RxJava에 Scheduler 제공
    }

    @Test
    fun testOnResponse(){
        // given
        val userLength = 10
        val users = Users(ArrayList(userLength))
        Mockito.`when`(userRepository.getUserList(userLength))
            .thenReturn(
                Observable.create { emitter ->
                    emitter.onNext(DataResult.Loading)

                    emitter.onNext(DataResult.Success(users))
                }
            )

        // when
        val result = getUserListUseCase(userLength)

        // then
        result
            .test()
            .assertValueAt(0, DataResult.Loading)
            .assertValueAt(1, DataResult.Success(users))
    }
}