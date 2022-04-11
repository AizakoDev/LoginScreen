package main

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Looper
import main.domain.LoginApi
import main.data.LoginApiImpl
import main.data.LoginUsecaseImpl
import main.domain.LoginUsecase

class App : Application() {
    private val loginApi: LoginApi by lazy { LoginApiImpl() }
    val loginUsecase: LoginUsecase by lazy {
        LoginUsecaseImpl(app.loginApi, Handler(Looper.getMainLooper()))
    }

}

val Context.app: App
    get() {
        return applicationContext as App
    }