package LoginScreen

interface View {
    fun setSuccess()
    fun setError(error: String)
    fun showProgress()
    fun hideProgress()
    fun workInProgress()
}