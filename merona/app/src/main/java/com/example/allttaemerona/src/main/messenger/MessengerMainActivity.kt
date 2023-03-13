package com.example.allttaemerona.src.main.messenger

import android.os.Bundle
import com.example.allttaemerona.R
import com.example.allttaemerona.config.BaseActivity
import com.example.allttaemerona.databinding.ActivityMessengerMainBinding
import com.example.allttaemerona.src.main.chat.ChatListFragment
import com.example.allttaemerona.src.main.messenger.check.DeliveryCheckFragment

class MessengerMainActivity : BaseActivity<ActivityMessengerMainBinding>(ActivityMessengerMainBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager
            .beginTransaction()
            .replace(binding.messengerFrm.id, DeliveryCheckFragment())
            .commitAllowingStateLoss()

        binding.navBottomMes.run {
            setOnItemSelectedListener {
                when(it.itemId){
                    R.id.menu_check -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.messengerFrm.id, DeliveryCheckFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_messenger_chat -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.messengerFrm.id, ChatListFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }
            selectedItemId = R.id.menu_check
        }
    }
}