package com.shinhan.mobmail.minji.randomuserwithtdd

import android.util.Log
import com.shinhan.mobmail.minji.randomuserwithtdd.data.UserDataSource
import com.shinhan.mobmail.minji.randomuserwithtdd.data.UserDataSourceImpl
import com.shinhan.mobmail.minji.randomuserwithtdd.data.UserRepositoryImpl
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.User
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.usecase.GetUserListUseCase
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.usecase.GetUserListUseCaseImpl
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.*
import org.junit.Test

class UserTest {
    @Test
    fun testUser(){
        val user = User()

        assertEquals("", user.name)
        assertEquals(0, user.age)
        assertEquals("", user.gender)
        assertEquals("", user.nation)
        assertEquals("", user.email)
        assertEquals("", user.phone)
        assertEquals("", user.cell)
        assertEquals("", user.profile)
    }

    @Test
    fun testUserDataSourceGetUserList() {
        // given
        val userDataSource = UserDataSourceImpl()
        val userLength = 10

        // when
        val single = userDataSource.getUserList(userLength).map {
            it
        }

        // then
        assertNotNull(single)
        assert(single is Single<ArrayList<User>>)
    }

    @Test
    fun testUserRepositoryGetUserList() {
        // given
        val userRepository = UserRepositoryImpl(UserDataSourceImpl())
        val userLength = 10

        // when

        // then
    }

    @Test
    fun testGetUserListUseCase() {
        // given
        val userUseCase = GetUserListUseCaseImpl(UserRepositoryImpl(UserDataSourceImpl()))
        val userLength = 10

        // when
        val result = userUseCase(userLength)

        // then
        assertNotNull(result)
    }
}