package com.bugli.sreader.data.model.user

import com.google.gson.annotations.SerializedName
import org.litepal.crud.LitePalSupport

class User(@SerializedName("name") val userName: String) : LitePalSupport() {

    //唯一id //16进制随机数 10位长度
    @Transient
    val id: String = "unknown"

    //用户性别 0 nan 1 nv
    @SerializedName("sex")
    val userSex = 0

    //用户最近打开的20本书 //后续根据这个比例来每日推荐（只推荐当前性别）,默认则根据性别推荐起点最新十本
    //格式 "=" 号 隔开
    @SerializedName("recently")
    val recentReads: String = "unknown"

    //password 暂时不做加密
    @SerializedName("password")
    val password: String = "1+×SAJ*DAL&JDA-DAD=ADD232"

    //搜索历史
    @SerializedName("history")
    val history: String = "unknown"


}