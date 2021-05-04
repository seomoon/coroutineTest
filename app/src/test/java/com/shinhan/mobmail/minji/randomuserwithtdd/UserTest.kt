package com.shinhan.mobmail.minji.randomuserwithtdd

import android.util.Log
import com.shinhan.mobmail.minji.randomuserwithtdd.data.UserDataSourceImpl
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.User
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
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
}