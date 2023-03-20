package com.example.allttaemerona.src.login

import android.content.Intent
import android.os.Bundle
import com.example.allttaemerona.config.BaseActivity
import com.example.allttaemerona.databinding.ActivityLoginBinding
import com.example.allttaemerona.src.main.SelectActivity
import com.example.allttaemerona.src.signup.SignupActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnSignup.setOnClickListener {
            var intent = Intent(this, SignupActivity::class.java)

            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            var intent = Intent(this, SelectActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}