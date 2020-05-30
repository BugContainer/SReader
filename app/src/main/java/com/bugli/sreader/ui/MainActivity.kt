package com.bugli.sreader.ui

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bugli.sreader.R
import com.bugli.sreader.ui.bookdata.BookDataFragment
import com.bugli.sreader.ui.bookself.BookSelfFragment
import com.bugli.sreader.util.InjectorUtil

class MainActivity : AppCompatActivity() {

    override fun onResume() {
        super.onResume()
        hideBottomUIMenu()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideBottomUIMenu()
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProvider(
            this,
            InjectorUtil.getBooKModelFactory()
        ).get(MainViewModel::class.java)
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

    private fun hideBottomUIMenu() {
        //隐藏虚拟按键，并且全屏
        val decorView: View = window.decorView
        val uiOptions: Int =
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        decorView.systemUiVisibility = uiOptions
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.statusBarColor = Color.GRAY;
    }
}
