package com.bugli.sreader.ui

import androidx.lifecycle.ViewModel
import com.bugli.sreader.data.BookRepository

class MainViewModel(private val repository: BookRepository) : ViewModel() {

    fun isAnyNovelInSelf() = repository.isAnyNovelsInSelf()


    fun getNewData() = repository.getNews()
}