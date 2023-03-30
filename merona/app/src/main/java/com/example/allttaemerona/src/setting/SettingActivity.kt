package com.example.allttaemerona.src.setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.allttaemerona.config.BaseActivity
import com.example.allttaemerona.databinding.ActivitySettingBinding
import com.example.allttaemerona.src.CustomToolbar

class SettingActivity : BaseActivity<ActivitySettingBinding>(ActivitySettingBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //toolbar 뒤로가기 버튼
        val toolbar = binding.customToolbar
        toolbar.setOnBackListener(OnBackListener())
    }

    //toolbar 뒤로가기 버튼
    inner class OnBackListener : CustomToolbar.OnBackListener {
        override fun onClick(view: View) {
            finish()
        }
    }
}