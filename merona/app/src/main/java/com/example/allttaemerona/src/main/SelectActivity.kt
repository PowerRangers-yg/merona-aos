package com.example.allttaemerona.src.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.allttaemerona.R
import com.example.allttaemerona.config.BaseActivity
import com.example.allttaemerona.databinding.ActivitySelectBinding
import com.example.allttaemerona.src.main.messenger.MessengerMainActivity
import com.example.allttaemerona.src.main.purchaser.PurchaserMainActivity

class SelectActivity : BaseActivity<ActivitySelectBinding>(ActivitySelectBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val purchaserBtn: Button = binding.btnPurchaser
        val messengerBtn: Button = binding.btnMessenger

        purchaserBtn.setOnClickListener {
            var intent = Intent(this, PurchaserMainActivity::class.java)
            startActivity(intent)
            finish()
        }

        messengerBtn.setOnClickListener {
            var intent = Intent(this, MessengerMainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}