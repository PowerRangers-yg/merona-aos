package com.example.allttaemerona.src.main.purchaser.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.allttaemerona.R
import com.example.allttaemerona.config.BaseFragment
import com.example.allttaemerona.databinding.FragmentRequestListBinding
import com.example.allttaemerona.src.CustomToolbar
import com.example.allttaemerona.src.main.SelectActivity
import com.example.allttaemerona.src.notification.NotificationActivity
import com.example.allttaemerona.src.setting.SettingActivity

class RequestListFragment: BaseFragment<FragmentRequestListBinding>(FragmentRequestListBinding::bind, R.layout.fragment_request_list){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addFab = binding.fabAdd
        val toolbar = binding.tbRequestList
        //toolbar 역할 변경 버튼
        toolbar.setOnSwitchListener(OnSwitchListener())
        //toolbar 알림창 버튼
        toolbar.setOnNotiListener(OnNotiListener())
        //toolbar 설정창 버튼
        toolbar.setOnSettingListener(OnSettingListener())

        addFab.setOnClickListener {
            val intent = Intent(requireActivity(), NewRequestActivity::class.java)
            startActivity(intent)
        }
    }

    //toolbar 역할 변경 버튼
    inner class OnSwitchListener : CustomToolbar.OnSwitchListener {
        override fun onClick(view: View) {
            val intent = Intent(requireActivity(), SelectActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }

    //toolbar 알림창 버튼
    inner class OnNotiListener : CustomToolbar.OnNotiListener {
        override fun onClick(view: View) {
            val intent = Intent(requireActivity(), NotificationActivity::class.java)
            startActivity(intent)
        }
    }

    //toolbar 설정창 버튼
    inner class OnSettingListener : CustomToolbar.OnSettingListener {
        override fun onClick(view: View) {
            val intent = Intent(requireActivity(), SettingActivity::class.java)
            startActivity(intent)
        }
    }
}