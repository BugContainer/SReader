package com.bugli.sreader.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bugli.sreader.R
import com.bugli.sreader.ui.bookdata.BookDataFragment
import com.bugli.sreader.ui.bookself.BookSelfFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        if (viewModel.isAnyNovelInSelf()) {
            //书架页面
            supportFragmentManager.beginTransaction().replace(R.id.container, BookSelfFragment())
                .commit()
        } else {
            //获取书籍数据页面
            supportFragmentManager.beginTransaction().replace(R.id.container, BookDataFragment())
                .commit()
        }
    }
}
