package com.example.qiitaclient2.data.container

import com.example.qiitaclient2.core.UrlBuilder
import com.example.qiitaclient2.data.api.Urls

class LoginContainer : Container {
    override fun getData(target: Targets, param: Map<String, String>): String {
        when (target) {
            Targets.LOGINURL -> {
                return UrlBuilder.setUrl(Urls.LOGIN_URL)
                    .setParameter("client_id", "690c6c96a29e14b18ec611eb4bd7a4a17ec2da01")
                    .setParameter("scope", "read_qiita write_qiita")
                    .setParameter("state", "bb17785d811bb1913ef54b0a7657de780defaa2d")
                    .build()
            }
        }
    }
}