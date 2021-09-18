package com.globomantic.login

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

var SCREEN_ORIENTATION: Int = -1
//const val EMAIL_REGEX =
//    "^[_A-Za-z\\+](\\.[_A-Za-z]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

const val EMAIL_REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

class MainActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SCREEN_ORIENTATION = resources.configuration.orientation

        email = findViewById(R.id.edit_text_email)
        password = findViewById(R.id.edit_text_password)
        loginButton = findViewById(R.id.button_login)

        loginButton.setOnClickListener {
            verifyCredentials(
                email.text.toString(),
                password.text.toString()
            )
        }
    }

    private fun verifyCredentials(email: String, password: String) {
        EMAIL_REGEX.apply {
            if (toRegex().containsMatchIn(email)) {
                CheckCredentials().execute(Pair(email, password))
            } else {
                loginFailed()
            }
        }
    }

    private fun loginSuccessful() {
        Snackbar.make(loginButton as View, "Login Successful", Snackbar.LENGTH_LONG).show()
    }

    private fun loginFailed() {
        Snackbar.make(loginButton as View, "Login Failed", Snackbar.LENGTH_LONG).show()
    }

    inner class CheckCredentials : AsyncTask<Pair<String, String>, Void, Boolean>() {
        override fun doInBackground(vararg params: Pair<String, String>): Boolean {
            Thread.sleep(2000)
            return loginData.contains(params[0])
        }

        override fun onPostExecute(isValid: Boolean) {
            super.onPostExecute(isValid)
            if (isValid) {
                loginSuccessful()
            } else {
                loginFailed()
            }
        }
    }
}