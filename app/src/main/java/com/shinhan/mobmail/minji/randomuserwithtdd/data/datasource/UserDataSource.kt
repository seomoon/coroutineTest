package com.shinhan.mobmail.minji.randomuserwithtdd.data.datasource

import com.shinhan.mobmail.minji.randomuserwithtdd.data.spec.R_Users
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.DataResult

interface UserDataSource {
    fun getUserList(size: Int): DataResult<R_Users>
}