package com.example.allttaemerona.src.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.allttaemerona.R
import com.example.allttaemerona.config.BaseActivity
import com.example.allttaemerona.databinding.ActivityNicknameBinding
import com.example.allttaemerona.src.login.LoginActivity

class NicknameActivity : BaseActivity<ActivityNicknameBinding>(ActivityNicknameBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnJoin.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
    }
}