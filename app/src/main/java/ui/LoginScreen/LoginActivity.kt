package ui.LoginScreen

import ui.MainWindow.MainWindowActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quarter_3_popularlibraries.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity(), ui.LoginScreen.View {

    private lateinit var vb: ActivityLoginBinding
    private var presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(vb.root)

        presenter = restorePresenter()
        presenter?.onAttach(this)

        vb.signInButton.setOnClickListener {
            presenter?.onLogin(
                vb.loginEditText.text.toString(),
                vb.passwordEditText.text.toString()
            )
        }

        vb.forgotPasswordTextView.setOnClickListener {
            workInProgress()
        }
        vb.joinNowTextView.setOnClickListener {
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
        val intent = Intent(this, MainWindowActivity::class.java)
        startActivity(intent)
    }

    override fun setError(error: String) {
        Toast.makeText(this, "ERROR $error", Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        vb.signInButton.isEnabled = false
    }

    override fun hideProgress() {
        vb.signInButton.isEnabled = true
    }

    override fun workInProgress() {
        Toast.makeText(this, "В разработке!", Toast.LENGTH_SHORT).show()
    }


}

