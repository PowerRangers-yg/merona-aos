package com.example.allttaemerona.src.main.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.allttaemerona.config.BaseActivity
import com.example.allttaemerona.databinding.ActivityChatBinding
import com.example.allttaemerona.src.CustomToolbar
import com.example.allttaemerona.src.main.SelectActivity
import com.example.allttaemerona.src.notification.NotificationActivity
import com.example.allttaemerona.src.setting.SettingActivity

class ChatActivity : BaseActivity<ActivityChatBinding>(ActivityChatBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolbar = binding.customToolbar
        //toolbar 뒤로가기 버튼
        toolbar.setOnBackListener(OnBackListener())
        //toolbar 역할 변경 버튼
        toolbar.setOnSwitchListener(OnSwitchListener())
        //toolbar 알림창 버튼
        toolbar.setOnNotiListener(OnNotiListener())
        //toolbar 설정창 버튼
        toolbar.setOnSettingListener(OnSettingListener())
    }

    //toolbar 역할 변경 버튼
    inner class OnSwitchListener : CustomToolbar.OnSwitchListener {
        override fun onClick(view: View) {
            val intent = Intent(this@ChatActivity, SelectActivity::class.java)
            startActivity(intent)
            //이전 activity도 종료시켜야함
            finish()
        }
    }

    //toolbar 알림창 버튼
    inner class OnNotiListener : CustomToolbar.OnNotiListener {
        override fun onClick(view: View) {
            val intent = Intent(this@ChatActivity, NotificationActivity::class.java)
            startActivity(intent)
        }
    }

    //toolbar 설정창 버튼
    inner class OnSettingListener : CustomToolbar.OnSettingListener {
        override fun onClick(view: View) {
            val intent = Intent(this@ChatActivity, SettingActivity::class.java)
            startActivity(intent)
        }
    }

    //toolbar 뒤로가기 버튼
    inner class OnBackListener : CustomToolbar.OnBackListener {
        override fun onClick(view: View) {
            finish()
        }
    }
}