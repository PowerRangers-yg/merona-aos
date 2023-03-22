package com.example.allttaemerona.src.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.example.allttaemerona.config.BaseActivity
import com.example.allttaemerona.databinding.ActivityLoginBinding
import com.example.allttaemerona.src.main.SelectActivity
import com.example.allttaemerona.src.signup.SignupActivity
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val idEdit: EditText = binding.etId
        val pwEdit: EditText = binding.etPw
        val btnSignup: Button = binding.btnSignup
        val btnLogin: Button = binding.btnLogin
        val btnKakao: ImageButton = binding.ibKakao
        val TAG: String = "카카오 로그인"

        var id: String = ""
        var pw: String = ""


        //카카오 로그인 확인
        /*UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
            if (error != null) {
                Log.e(TAG, "로그인 실패", error)
            }
            else if (token != null) {
                Log.i(TAG, "로그인 성공 ${token.accessToken}")
                //로그인 성공 시 선택화면으로 전환
                intentSelectActivity()
            }
        }*/

        //카카오 로그인 버튼
        //카카오 최초 회원가입이라면 닉네임 화면으로 전환 필요
        btnKakao.setOnClickListener {
            // 카카오계정으로 로그인 공통 callback 구성
            // 카카오톡으로 로그인 할 수 없어 카카오계정으로 로그인할 경우 사용됨
            val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
                if (error != null) {
                    Log.e(TAG, "카카오계정으로 로그인 실패", error)
                } else if (token != null) {
                    Log.i(TAG, "카카오계정으로 로그인 성공 ${token.accessToken}")
                    intentSelectActivity()
                }
            }

            // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
                UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                    if (error != null) {
                        Log.e(TAG, "카카오톡으로 로그인 실패", error)

                        // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                        // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                        if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                            return@loginWithKakaoTalk
                        }

                        // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                        UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
                    } else if (token != null) {
                        Log.i(TAG, "카카오톡으로 로그인 성공 ${token.accessToken}")
                        intentSelectActivity()
                    }
                }
            } else {
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
            }
        }


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

    fun intentSelectActivity(){
        var intent = Intent(this, SelectActivity::class.java)
        startActivity(intent)
        finish()
    }
}