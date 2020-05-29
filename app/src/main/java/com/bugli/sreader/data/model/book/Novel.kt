package com.bugli.sreader.data.model.book

import com.google.gson.annotations.SerializedName
import org.litepal.crud.LitePalSupport

class Novel(@SerializedName("name") val novelName: String) : LitePalSupport() {
    //唯一id //16进制随机数 10位长度
    @Transient
    val id: String = "unknown"

    //作者
    @SerializedName("author")
    val novelAuthor: String = "unknown"

    //简介
    @SerializedName("intro")
    val novelIntro: String = "unknown"

    //分类
    @SerializedName("type")
    val novelType: String = "unknown"

    //网络图片 网络地址
    @SerializedName("imgUrl")
    val novelImgUrl: String = "unknown"

    //本地图片 如果网络地址为unknown则使用 本地图片(有默认图片，暂且使用unknown
    @SerializedName("imgPath")
    val novelImgPath: String = "unknown"

    //小说网络地址
    @SerializedName("url")
    val novelUrl: String = "unknown"

    //小说本地存储地址 //一本小说一个目录,一章一个文件 00000 5位数字 + 章节名+.wtf后缀
    @SerializedName("path")
    val novelPath: String = "unknown"

    //小说当前来源网站
    @SerializedName("site")
    val novelSite: String = "unknown"

    //当前已阅读到章节
    @SerializedName("cChapter")
    val novelCChapter = 0

    //已阅读到章节的页数
    @SerializedName("cPage")
    val novelCPage = 0

    //书签章节  格式 1=2=12  表示 1 2 12 章节
    @SerializedName("markChapter")
    val novelMarkChapter: String = "unknown"

    //书签页数 格式 1*20*12 表示 1 20 12 页
    @SerializedName("markPage")
    val novelMarkPage: String = "unknown"


}