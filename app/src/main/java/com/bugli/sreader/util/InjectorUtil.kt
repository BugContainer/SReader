package com.bugli.sreader.util

import com.bugli.sreader.data.BookRepository
import com.bugli.sreader.data.db.SReaderDB
import com.bugli.sreader.data.network.api.BookNetwork
import com.bugli.sreader.ui.MainModelFactory

object InjectorUtil {

    private fun getBooKRepository() = BookRepository.getInstance(
        SReaderDB.getBookDao(),
        BookNetwork.getInstance()
    )

    fun getBooKModelFactory() = MainModelFactory(getBooKRepository())
}