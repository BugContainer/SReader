package com.bugli.sreader.util

import android.content.Context
import android.graphics.Point
import android.view.Display
import android.view.View
import android.view.WindowManager

object GetPoint {


    //获取屏幕宽高
    fun getWinWH(context: Context): Point {
        val defaultDisplay: Display =
            (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
        val point = Point()
        defaultDisplay.getSize(point)
        return point
    }


    //获取View宽高
    fun getLoc(v: View): IntArray {
        val loc = intArrayOf()
        val w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        val h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        v.measure(w, h)
        loc[0] = v.measuredWidth
        loc[1] = v.measuredHeight
        return loc
    }

    fun dp2px(context: Context, dipValue: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (dipValue * scale + 0.5f).toInt()
    }


}