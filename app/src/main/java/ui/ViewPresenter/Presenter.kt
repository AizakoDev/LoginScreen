package ui.ViewPresenter

interface Presenter {
    fun onAttach(view: View)
    fun onLogin(login: String, password: String)
}