package com.example.allttaemerona.src.main.purchaser.list

import android.os.Bundle
import android.view.View
import com.example.allttaemerona.config.BaseActivity
import com.example.allttaemerona.databinding.ActivityNewRequestBinding
import com.example.allttaemerona.src.CustomToolbar

class NewRequestActivity: BaseActivity<ActivityNewRequestBinding>(ActivityNewRequestBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //toolbar 뒤로가기 버튼
        val toolbar = binding.toolbar
        toolbar.setOnBackListener(OnBackListener())
    }

    //toolbar 뒤로가기 버튼
    inner class OnBackListener : CustomToolbar.OnBackListener {
        override fun onClick(view: View) {
            finish()
        }
    }
}