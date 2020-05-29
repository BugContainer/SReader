package com.bugli.sreader.data.db

import com.bugli.sreader.data.model.user.User
import org.litepal.LitePal

class UserDao {

    fun getUserList(): MutableList<User> = LitePal.findAll(User::class.java)


    fun saveUserList(userList: List<User>) {

        if (userList.isNotEmpty()) {
            LitePal.saveAll(userList)
        }
    }
}