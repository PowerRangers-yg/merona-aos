package com.example.allttaemerona.src.signup

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.allttaemerona.config.BaseActivity
import com.example.allttaemerona.databinding.ActivitySignupBinding
import java.util.regex.Pattern

class SignupActivity : BaseActivity<ActivitySignupBinding>(ActivitySignupBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val idEdit: EditText = binding.etIdSignup
        val pwEdit: EditText = binding.etPwSignup
        val pwCheckEdit: EditText = binding.etPwCheck
        val cancelBtn: Button = binding.btnCancel
        val nextBtn: Button = binding.btnNext
        val idCheckBtn: Button = binding.btnIdCheck

        var idError: TextView = binding.tvIdError
        var pwError: TextView = binding.tvPwError
        var pwCheckError: TextView = binding.tvPwCheckError
        var id: String = ""
        var idDoubleCheck: Boolean = false
        var pwMatch: Boolean = false

        idCheckBtn.isEnabled = false


        //id 유효성 확인
        idEdit.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                id = idEdit.text.toString()
                idDoubleCheck = false
                if (!Patterns.EMAIL_ADDRESS.matcher(id).matches()){
                    idError.text = "유효하지 않은 이메일 주소입니다."
                    idCheckBtn.isEnabled = false
                } else {
                    idError.text = ""
                    idCheckBtn.isEnabled = true
                }
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        //비밀번호 유효성 확인 및 비밀번호 일치
        pwEdit.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (pwEdit.text.toString() == pwCheckEdit.text.toString()){
                    pwCheckError.text = null
                    pwMatch = true
                } else {
                    pwCheckError.text = "비밀번호가 일치하지 않습니다."
                    pwMatch = false
                }

                if (p0.toString().isEmpty()){
                    pwError.text = "공백은 허용하지않습니다."
                } else if (!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,15}\$", p0.toString())){
                    pwError.text = "영문, 숫자를 포함한 8~15자의 비밀번호를 입력해주세요"
                } else {
                    pwError.text = null
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                if (pwEdit.text.toString() == pwCheckEdit.text.toString()){
                    pwCheckError.text = null
                    pwMatch = true
                } else {
                    pwCheckError.text = "비밀번호가 일치하지 않습니다."
                    pwMatch = false
                }
            }
        })

        //비밀번호 일치 확인
        pwCheckEdit.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (pwEdit.text.toString() == pwCheckEdit.text.toString()){
                    pwCheckError.text = null
                    pwMatch = true
                } else {
                    pwCheckError.text = "비밀번호가 일치하지 않습니다."
                    pwMatch = false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                if (pwEdit.text.toString() == pwCheckEdit.text.toString()){
                    pwCheckError.text = null
                    pwMatch = true
                } else {
                    pwCheckError.text = "비밀번호가 일치하지 않습니다."
                    pwMatch = false
                }
            }
        })

        //중복확인 버튼
        idCheckBtn.setOnClickListener {
            idDoubleCheck = true
            showCustomToast("사용가능한 이메일입니다.")

        }

        //회원가입 취소
        cancelBtn.setOnClickListener {
            finish()
        }

        //다음 버튼
        nextBtn.setOnClickListener {
            if (idDoubleCheck && pwMatch){
                var intent = Intent(this, NicknameActivity::class.java)
                startActivity(intent)
            } else if (!idDoubleCheck) {
                showCustomToast("아이디 중복확인을 해주세요.")
            } else if (!pwMatch) {
                showCustomToast("비밀번호가 일치하지 않습니다.")
            }
        }
    }
}