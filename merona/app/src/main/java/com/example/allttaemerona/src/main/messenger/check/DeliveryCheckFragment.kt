package com.example.allttaemerona.src.main.messenger.check

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.allttaemerona.R
import com.example.allttaemerona.config.BaseFragment
import com.example.allttaemerona.databinding.FragmentDeliveryCheckBinding
import com.example.allttaemerona.src.CustomToolbar
import com.example.allttaemerona.src.main.SelectActivity
import com.example.allttaemerona.src.notification.NotificationActivity
import com.example.allttaemerona.src.setting.SettingActivity
import com.naver.maps.map.MapView

class DeliveryCheckFragment : BaseFragment<FragmentDeliveryCheckBinding>(FragmentDeliveryCheckBinding::bind, R.layout.fragment_delivery_check){
    private lateinit var mapView: MapView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)

        val toolbar = binding.toolbar
        //toolbar 역할 변경 버튼
        toolbar.setOnSwitchListener(OnSwitchListener())
        //toolbar 알림창 버튼
        toolbar.setOnNotiListener(OnNotiListener())
        //toolbar 설정창 버튼
        toolbar.setOnSettingListener(OnSettingListener())
    }
    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
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