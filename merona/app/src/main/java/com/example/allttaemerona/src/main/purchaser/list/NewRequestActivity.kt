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

        val editTime = binding.tvTimeSetting
        val editPay = binding.tvPaySetting

        editTime.setOnClickListener {
            var initNum = 0
            if (editTime.text != null ){
                initNum = editTime.text.toString().toInt()
            }
            val dialog = NumberPickerDialog("시간", initNum, 100, 0, 5)
            dialog.setOnOkClickedListener { content ->
                editTime.text = content.toString()
            }
            dialog.isCancelable = false
            dialog.show(supportFragmentManager, "time" )
        }

        editPay.setOnClickListener{
            var initNum = 0
            if (editPay.text != null ){
                initNum = editPay.text.toString().toInt()
            }
            val dialog = NumberPickerDialog("배송료", initNum, 10000, 0, 500)
            dialog.setOnOkClickedListener { content ->
                editPay.text = content.toString()
            }
            dialog.isCancelable = false
            dialog.show(supportFragmentManager, "pay" )
        }
    }

    //toolbar 뒤로가기 버튼
    inner class OnBackListener : CustomToolbar.OnBackListener {
        override fun onClick(view: View) {
            finish()
        }
    }
}