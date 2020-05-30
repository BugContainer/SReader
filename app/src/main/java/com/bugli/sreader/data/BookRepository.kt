package com.bugli.sreader.data

import android.os.Build
import android.view.View
import android.view.WindowManager
import com.bugli.sreader.data.db.BookDao
import com.bugli.sreader.data.model.book.Novel
import com.bugli.sreader.data.model.book.SelfNovel
import com.bugli.sreader.data.network.api.BookNetwork
import org.litepal.LitePal

class BookRepository private constructor(
    private val bookDao: BookDao,
    private val network: BookNetwork
) {


    fun isAnyNovelsInSelf(): Boolean {
        //判断书架中是否有书籍 有则显示书架页面 无则显示每日推荐（即搜索页面）
        return LitePal.findAll(SelfNovel::class.java).isNotEmpty()
    }


    fun getNews(){
        //获取每日推荐  如果有最近打开记录
    }

    companion object {

        private lateinit var instance: BookRepository

        fun getInstance(weatherDao: BookDao, network: BookNetwork): BookRepository {
            if (!::instance.isInitialized) {
                synchronized(BookRepository::class.java) {
                    if (!::instance.isInitialized) {
                        instance = BookRepository(weatherDao, network)
                    }
                }
            }
            return instance
        }

    }

}