package com.bugli.sreader

import android.app.Application
import android.content.Context
import org.litepal.LitePal

class SReaderApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        LitePal.initialize(this)
        context = this
    }

    companion object {
        lateinit var context: Context
    }
}