package com.shinhan.mobmail.minji.randomuserwithtdd

import com.shinhan.mobmail.minji.randomuserwithtdd.data.UserDataSourceImpl
import com.shinhan.mobmail.minji.randomuserwithtdd.data.UserRepositoryImpl
import com.shinhan.mobmail.minji.randomuserwithtdd.data.spec.mapper.UserMapper
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.User
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.usecase.GetUserListUseCaseImpl
import junit.framework.Assert.*
import org.junit.Test

class UserTest {
    @Test
    fun testUser(){
        val user = User()

        assertEquals("", user.name)
        assertEquals("", user.age)
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
            UserMapper.mapToEntity(it)
        }

        // then
        assertNotNull(single)
    }

    @Test
    fun testUserRepositoryGetUserList() {
        // given
        val userRepository = UserRepositoryImpl(UserDataSourceImpl())
        val userLength = 10

        // when
        val result = userRepository.getUserList(userLength)

        // then
        assertNotNull(result)
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