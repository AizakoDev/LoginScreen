package LoginScreen

import android.os.Handler
import android.os.Looper

class LoginPresenter: Presenter {
    private var view: View? = null
    private val uiHandler = Handler(Looper.getMainLooper())

    override fun onAttach(view: View) {
        this.view = view
    }

    override fun onLogin(login: String, password: String) {
        view?.showProgress()
        Thread {
            uiHandler.post {
                view?.hideProgress()
                if (checkCredentials(login, password)) {
                    view?.setSuccess()
                } else {
                    view?.setError("Неверный пароль!!!")
                }
            }
        }.start()
    }



    private fun checkCredentials(login: String, password: String): Boolean {
        return login == password
    }


}