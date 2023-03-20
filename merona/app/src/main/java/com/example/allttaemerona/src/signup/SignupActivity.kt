package com.example.allttaemerona.src.signup

import android.content.Intent
import android.os.Bundle
import com.example.allttaemerona.config.BaseActivity
import com.example.allttaemerona.databinding.ActivitySignupBinding

class SignupActivity : BaseActivity<ActivitySignupBinding>(ActivitySignupBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnCancel.setOnClickListener {
            finish()
        }

        binding.btnNext.setOnClickListener {
            var intent = Intent(this, NicknameActivity::class.java)
            startActivity(intent)
        }
    }
}