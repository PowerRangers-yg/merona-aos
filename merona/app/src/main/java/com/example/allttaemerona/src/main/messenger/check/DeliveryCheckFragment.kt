package com.example.allttaemerona.src.main.messenger.check

import android.os.Bundle
import android.view.View
import com.example.allttaemerona.R
import com.example.allttaemerona.config.BaseFragment
import com.example.allttaemerona.databinding.FragmentDeliveryCheckBinding
import com.naver.maps.map.MapView

class DeliveryCheckFragment : BaseFragment<FragmentDeliveryCheckBinding>(FragmentDeliveryCheckBinding::bind, R.layout.fragment_delivery_check){
    private lateinit var mapView: MapView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)
        //val mapView = MapView(context)
        //.kakaoMapView.addView(mapView)
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
}