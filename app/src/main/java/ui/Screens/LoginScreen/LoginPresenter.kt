package ui.Screens.LoginScreen

import android.os.Handler
import android.os.Looper
import main.domain.LoginUsecase
import ui.ViewPresenter.Presenter
import ui.ViewPresenter.View

class LoginPresenter(private val loginUsecase: LoginUsecase): Presenter {
    private var view: View? = null
//    private val uiHandler = Handler(Looper.getMainLooper())

    override fun onAttach(view: View) {
        this.view = view
    }

    override fun onLogin(login: String, password: String) {
        view?.showProgress()
        loginUsecase.login(login, password) {
            view?.hideProgress()
            if (checkCredentials(login, password)) {
                view?.setSuccess()
            } else {
                view?.setError("Неверный пароль!!!")
            }
        }
    }

    private fun checkCredentials(login: String, password: String): Boolean {
        return login == password
    }


}