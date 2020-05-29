package com.bugli.sreader.data.db

import com.bugli.sreader.data.model.book.Novel
import com.bugli.sreader.data.model.book.SelfNovel
import org.litepal.LitePal

class BookDao {
    //获取本地索引过的数据
    fun getNovelList(): MutableList<Novel> = LitePal.findAll(Novel::class.java)
    //获取书架中的数据
    fun getNovelListInSelf(): MutableList<SelfNovel> = LitePal.findAll(SelfNovel::class.java)

    fun saveNovelList(novelList: List<Novel>) {
        if (novelList.isNotEmpty()) {
            LitePal.saveAll(novelList)
        }

    }
    fun saveSelfNovelList(novelList: List<SelfNovel>) {
        if (novelList.isNotEmpty()) {
            LitePal.saveAll(novelList)
        }
    }

}