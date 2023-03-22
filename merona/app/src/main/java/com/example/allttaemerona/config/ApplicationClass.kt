package com.example.allttaemerona.config

import android.app.Application
import android.content.SharedPreferences
import com.example.allttaemerona.R
import com.kakao.sdk.common.KakaoSdk
import retrofit2.Retrofit

class ApplicationClass: Application() {
    //val API_URL = "추후에 추가"

    companion object {
        lateinit var sSharedPreferences: SharedPreferences
        lateinit var  sRetrofit: Retrofit

    }

    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, getString(R.string.kakao_native_app_key))
        sSharedPreferences =
            applicationContext.getSharedPreferences("MERONA_APP", MODE_PRIVATE)
    }

}