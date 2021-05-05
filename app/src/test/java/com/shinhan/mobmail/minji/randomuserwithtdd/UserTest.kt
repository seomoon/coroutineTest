package com.shinhan.mobmail.minji.randomuserwithtdd

import com.shinhan.mobmail.minji.randomuserwithtdd.data.UserDataSourceImpl
import com.shinhan.mobmail.minji.randomuserwithtdd.data.UserRepositoryImpl
import com.shinhan.mobmail.minji.randomuserwithtdd.data.spec.R_Users
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.User
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.usecase.GetUserListUseCaseImpl
import io.reactivex.Single
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
        assert(single is Single<R_Users>)
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