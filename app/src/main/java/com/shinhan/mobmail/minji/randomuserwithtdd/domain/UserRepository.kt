package com.shinhan.mobmail.minji.randomuserwithtdd.domain

import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.Users

interface UserRepository {
    fun getUserList(size: Int): DataResult<Users>
}