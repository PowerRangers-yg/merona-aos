package com.example.allttaemerona.src.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.allttaemerona.R
import com.example.allttaemerona.config.BaseActivity
import com.example.allttaemerona.databinding.ActivityNicknameBinding
import com.example.allttaemerona.src.login.LoginActivity
import java.util.regex.Pattern

class NicknameActivity : BaseActivity<ActivityNicknameBinding>(ActivityNicknameBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nicknameEdit: EditText = binding.etNickname
        val backBtn: Button = binding.btnBack
        val joinBtn: Button = binding.btnJoin
        val nicknameCheckBtn: Button = binding.btnNicknameCheck

        var nicknameError: TextView = binding.tvNicknameError
        var nicknameCheck: Boolean = false
        nicknameCheckBtn.isEnabled = false

        //닉네임 유효성 검사
        nicknameEdit.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                nicknameCheck = false

                if (p0.toString().isEmpty()){
                    nicknameError.text = "공백은 허용하지 않습니다."
                    nicknameCheckBtn.isEnabled = false
                } else if (!Pattern.matches("^[\\s가-힣a-zA-Z0-9]{2,20}\$", p0.toString())){
                    nicknameError.text = "사용할 수 없는 문자가 포함되어 있습니다."
                    nicknameCheckBtn.isEnabled = false
                } else {
                    nicknameCheckBtn.isEnabled = true
                    nicknameError.text = null
                }
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

        //중복확인 버튼
        nicknameCheckBtn.setOnClickListener {
            nicknameCheck = true
            showCustomToast("사용가능한 닉네임입니다.")
        }

        //뒤로가기 버튼ㄱ
        backBtn.setOnClickListener {
            finish()
        }

        //회원가입 버튼(스택 전부 없애고 첫화면으로 돌아가는 부분 수정 필요,, 스플래시 화면이 잠시 나타남)
        joinBtn.setOnClickListener {
            if (nicknameCheck){
                var intent = Intent(this, LoginActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }

        }
    }
}