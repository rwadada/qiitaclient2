package com.example.qiitaclient2.core

import com.example.qiitaclient2.ViewHandler

object ApplicationHolder {
    var viewHandler: ViewHandler = object : ViewHandler{
        override fun visibleFooter() {
            // NOP
        }

        override fun visibleHeader() {
            // NOP
        }
    }

    var accessToken = ""

    var queryParams = QueryParams("", "")

    var status = Status.UNAUTHENTICATED

}

data class QueryParams(
    var code: String = "",
    var state: String = ""
)

fun QueryParams.setData(code: String?, state: String?) {
    if (code == null) {
        this.code = ""
    } else {
        this.code = code
    }

    if (state == null) {
        this.state = ""
    } else {
        this.state = state
    }
}

fun QueryParams.clearData() {
    this.code = ""
    this.state = ""
}

enum class Status() {
    AUTHENTICATED,
    UNAUTHENTICATED,
    FAILURE
}