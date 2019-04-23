package com.example.qiitaclient2.core

import java.lang.StringBuilder

object UrlBuilder {
    private var mUrlBuilder: UrlBuilder = this
    private lateinit var resultUrl: StringBuilder
    private var firstFlg = true

    fun setUrl(url: String): UrlBuilder {
        resultUrl = StringBuilder()
        firstFlg = true
        resultUrl.append(url)
        return mUrlBuilder
    }

    fun setParameter(key: String, value: String): UrlBuilder {
        if (firstFlg) {
            resultUrl.append("?$key=$value")
            firstFlg = false
        } else {
            resultUrl.append("&$key=$value")
        }
        return mUrlBuilder
    }

    fun build(): String{
        return resultUrl.toString()
    }
}
