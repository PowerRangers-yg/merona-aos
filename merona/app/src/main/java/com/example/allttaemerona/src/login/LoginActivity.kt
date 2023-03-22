package com.example.allttaemerona.src.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import com.example.allttaemerona.config.BaseActivity
import com.example.allttaemerona.databinding.ActivityLoginBinding
import com.example.allttaemerona.src.main.SelectActivity
import com.example.allttaemerona.src.signup.SignupActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val idEdit: EditText = binding.etId
        val pwEdit: EditText = binding.etPw
        val btnSignup: Button = binding.btnSignup
        val btnLogin: Button = binding.btnLogin
        var id: String = ""
        var pw: String = ""


        //회원가입 버튼
        btnSignup.setOnClickListener {
            var intent = Intent(this, SignupActivity::class.java)

            startActivity(intent)
        }

        //로그인 버튼
        btnLogin.setOnClickListener {
            id = idEdit.text.toString()
            pw = pwEdit.text.toString()

            if (id.isEmpty() || pw.isEmpty()){
                showCustomToast("아이디와 비밀번호를 입력해주세요")
            } else if (!Patterns.EMAIL_ADDRESS.matcher(id).matches()){
                showCustomToast("유효하지 않은 이메일 주소입니다.")
            } else {
                var intent = Intent(this, SelectActivity::class.java)
                startActivity(intent)
                finish()
            }
            //else if (아이디 비밀번호 일치 X)

        }
    }
}