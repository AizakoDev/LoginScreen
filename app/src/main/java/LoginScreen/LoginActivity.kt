package LoginScreen

import MainWindow.MainWindow
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quarter_3_popularlibraries.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity(), LoginScreen.View {

    private lateinit var vb: ActivityLoginBinding
    private var presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(vb.root)

        presenter = restorePresenter()
        presenter?.onAttach(this)

        vb.buttonSignIn.setOnClickListener {
            presenter?.onLogin(
                vb.editTextTextLogin.text.toString(),
                vb.editTextTextPassword.text.toString()
            )
        }

        vb.textViewForgotPassword.setOnClickListener {
            workInProgress()
        }
        vb.textViewJoinNow.setOnClickListener {
            workInProgress()
        }

    }

    private fun restorePresenter(): LoginPresenter {
        val presenter = lastCustomNonConfigurationInstance as? LoginPresenter
        return presenter ?: LoginPresenter()
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        return presenter
    }

    override fun setSuccess() {
        val intent = Intent(this, MainWindow::class.java)
        startActivity(intent)
    }

    override fun setError(error: String) {
        Toast.makeText(this, "ERROR $error", Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        vb.buttonSignIn.isEnabled = false
    }

    override fun hideProgress() {
        vb.buttonSignIn.isEnabled = true
    }

    override fun workInProgress() {
        Toast.makeText(this, "В разработке!", Toast.LENGTH_SHORT).show()
    }


}

