package com.example.qiitaclient2.core

import com.example.qiitaclient2.ViewHandler

object Container {
    var viewHandler: ViewHandler = object : ViewHandler{
        override fun visibleFooter() {
            // NOP
        }

        override fun visibleHeader() {
            // NOP
        }
    }
}