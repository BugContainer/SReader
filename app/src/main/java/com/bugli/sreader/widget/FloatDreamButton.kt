package com.bugli.sreader.widget

import android.content.Context
import android.os.Handler
import android.os.Message
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import kotlinx.coroutines.*
import kotlin.math.sqrt


class FloatDreamButton : androidx.appcompat.widget.AppCompatImageView {
    var isDrag = false
    private var lastX = 0f
    private var lastY = 0f
    private var parentWidth = 0
    private var parentHeight = 0
    private lateinit var mParent: ViewGroup

    private var inHideState: Boolean = false

    private var job: Job? = null

    private constructor(context: Context) : super(context) {

    }

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs) {
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
    }


    override fun onTouchEvent(ev: MotionEvent): Boolean {
        val rawX = ev.rawX
        val rawY = ev.rawY
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                //Log.e("bugli", "ACTION_DOWN")

                isDrag = false
                alpha = 0.9f
                isPressed = !isPressed
                parent.requestDisallowInterceptTouchEvent(true)
                //按下事件在move之前，获取初始位置坐标
                lastX = rawX
                lastY = rawY
                //获取父控件属性
                if (parent != null) {
                    mParent = parent as ViewGroup
                    parentHeight = mParent.height
                    parentWidth = mParent.width

                }

                showBtn()
                //Log.e(
//                    "bugli",
//                    "$lastX ----$lastY---- $parent ----${mParent.height} -----${mParent.width}"
//                )
            }
            MotionEvent.ACTION_MOVE -> {
                //从隐藏中出来的过程中不允许滑动，并且必须Up之后才可以滑动
                if (x < 0 || x + width > parentWidth || inHideState) {
                    return false
                }
                //移动的时候关闭协程 避免吸附到边界
                job?.cancel()
                alpha = 0.9f
                val dx = rawX - lastX
                val dy = rawY - lastY
                val distance = sqrt(dx * dx + dy * dy)
                if (distance > 2 && !isDrag) {
                    isDrag = true
                }
                var cx = x + dx
                var cy = y + dy

                //检测是否到达屏幕边缘
                if (cx < 0)
                    cx = 0f
                else if (cx > parentWidth - width) {
                    cx = (parentWidth - width).toFloat()
                }

                if (y < 0)
                    cy = 0f
                else if (y + height > parentHeight) {
                    cy = (parentHeight - height).toFloat()
                }

                x = cx
                y = cy
                lastX = rawX
                lastY = rawY
            }

            MotionEvent.ACTION_UP -> {
                inHideState = false
                //Log.e("bugli", "ACTION_UP")
                if (isDrag) {
                    isPressed = false
                }
                delayLoc(1000)
            }
        }

        //Log.e("bugli", "$isDrag===$width")
        //拖拽则消耗掉事件，否则往下传递
        return true
    }


    private val mHandler: Handler = Handler {
        when (it.what) {
            0 -> {
                moveHide()
            }

        }
        false
    }

    //延迟吸附边界
    private fun delayLoc(time: Long) {
        job = GlobalScope.launch(Dispatchers.Default) {
            delay(time)
            val msg = Message()
            msg.what = 0
            mHandler.sendMessage(msg)

        }
    }

    private fun moveHide() {
        if (x >= parentWidth - 2 * width) { //500
            //靠右吸附
            //Log.e(
//                "bugli======",
//                (parentWidth - width - x - GetPoint.dp2px(context, 50 - width / 2)).toString()
//            )
            animate().setInterpolator(DecelerateInterpolator())
                .setDuration(500) //父控件宽 - 当前 btn x坐标 - btn宽 = btn 右边距离父控件距li xBy参数为位移距离 width/2为隐藏的部分
                .xBy(parentWidth - width - x + width * 3 / 4)
                .start()
            isPressed = false
        } else if (x <= width) {

            animate().setInterpolator(DecelerateInterpolator())
                .setDuration(500) //父控件宽 - 当前 btn x坐标 - btn宽 = btn 右边距离父控件距li xBy参数为位移距离 width/2为隐藏的部分
                .xBy(-x - width * 3 / 4)
                .start()
            isPressed = false
            //靠左吸附
/*            //ObjectAnimator oa = ObjectAnimator.ofFloat(this, "x", getX(), 0);  //这里是另一种动画方式
            val oa = ObjectAnimator.ofFloat(
                this, "x",
                x,
                GetPoint.dp2px(context, 50 - width / 2).toFloat()
            )
            oa.interpolator = DecelerateInterpolator()
            oa.duration = 500
            oa.start()*/
        }
        job!!.cancel()

    }

    private fun showBtn() {
        if (x < 0) {
            //左边
            animate().setInterpolator(DecelerateInterpolator())
                .setDuration(500) //父控件宽 - 当前 btn x坐标 - btn宽 = btn 右边距离父控件距li xBy参数为位移距离 width/2为隐藏的部分
                .xBy(0f + width * 3 / 4)
                .start()
            isPressed = false
            inHideState = true
        } else if (x > parentWidth - width / 3) {
            //右边
            animate().setInterpolator(DecelerateInterpolator())
                .setDuration(500) //父控件宽 - 当前 btn x坐标 - btn宽 = btn 右边距离父控件距li xBy参数为位移距离 width/2为隐藏的部分
                .xBy(0f - width * 3 / 4)
                .start()
            isPressed = false
            inHideState = true
        }
    }

}