package com.hyperion.demovalidatesameios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        root.setOnClickListener {
            KeyboardManager.hideKeyboard(this)
            if (!etPassword.text.isNullOrEmpty()) {
                validate(etPassword, password)
            }
            if (!etUser.text.isNullOrEmpty()) {
                validate(etUser, email)
            }
        }
        etUser.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) email.text = ""
            validate(etPassword, password)
        }

        etPassword.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) password.text = ""
            validate(etUser, email)
        }

    }

    private fun validate(editTextValidate: EditText, textViewShowError: TextView) {
        if (!editTextValidate.text.isNullOrEmpty()) {
            val error = ValidateUtils.validateEmail(editTextValidate.text.toString())
            textViewShowError.text = error
        }
    }
}
