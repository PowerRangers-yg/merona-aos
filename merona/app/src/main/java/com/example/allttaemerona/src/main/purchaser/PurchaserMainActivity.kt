package com.example.allttaemerona.src.main.purchaser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.allttaemerona.R
import com.example.allttaemerona.config.BaseActivity
import com.example.allttaemerona.databinding.ActivityPurchaserMainBinding
import com.example.allttaemerona.src.main.purchaser.chat.PurchaserChatListFragment
import com.example.allttaemerona.src.main.purchaser.list.RequestListFragment

class PurchaserMainActivity : BaseActivity<ActivityPurchaserMainBinding>(ActivityPurchaserMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager
            .beginTransaction()
            .replace(binding.purchaserFrm.id, RequestListFragment())
            .commitAllowingStateLoss()

        binding.navBottomPur.run {
            setOnItemSelectedListener {
                when(it.itemId){
                    R.id.menu_list -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.purchaserFrm.id, RequestListFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_purchaser_chat -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.purchaserFrm.id, PurchaserChatListFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }
            selectedItemId = R.id.menu_list
        }
    }
}