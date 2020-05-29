package com.bugli.sreader.data.db

object SReaderDB {

    private var userDao: UserDao? = null
    private var bookDao: BookDao? = null


    fun getUserDao(): UserDao {
        if (userDao == null) {
            userDao = UserDao()
        }
        return userDao!!
    }

    fun getBookDao(): BookDao {
        if (bookDao == null) {
            bookDao = BookDao()
        }
        return bookDao!!
    }
}