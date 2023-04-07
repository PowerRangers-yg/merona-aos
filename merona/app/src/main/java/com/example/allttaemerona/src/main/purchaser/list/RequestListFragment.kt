package com.example.allttaemerona.src.main.purchaser.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allttaemerona.R
import com.example.allttaemerona.config.BaseFragment
import com.example.allttaemerona.databinding.FragmentRequestListBinding
import com.example.allttaemerona.src.CustomToolbar
import com.example.allttaemerona.src.main.SelectActivity
import com.example.allttaemerona.src.main.purchaser.list.models.RequestItem
import com.example.allttaemerona.src.notification.NotificationActivity
import com.example.allttaemerona.src.setting.SettingActivity

class RequestListFragment: BaseFragment<FragmentRequestListBinding>(FragmentRequestListBinding::bind, R.layout.fragment_request_list){
    private val requestDataList: ArrayList<RequestItem> = arrayListOf()
    private val requestDataRVAdapter = RequestItemRVAdapter(requestDataList)

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

        requestDataList.add(RequestItem("", "주소", 30, 3000, "과자"))
        binding.rvRequestList.adapter = requestDataRVAdapter
        binding.rvRequestList.layoutManager = LinearLayoutManager(requireActivity())

        requestDataRVAdapter.setItemClickListener(object : RequestItemRVAdapter.OnItemClickListener{
            override fun onItemClick(v: View, position: Int) {
                showCustomToast(position.toString())
            }

            override fun onMatchingClick(v: View, position: Int) {
                showCustomToast("매칭")
            }

            override fun onMenuClick(v: View, position: Int) {
                showMenu(v, position)
            }

        })
    }

    private fun showMenu(v: View, position: Int) {
        val popup = PopupMenu(requireActivity(), v)
        popup.menuInflater.inflate(R.menu.menu_request, popup.menu)
        popup.setOnMenuItemClickListener { item ->
            when (item?.itemId){
                R.id.menu_update -> {
                    true
                }
                R.id.menu_delete -> {
                    val position = position
                    requestDataRVAdapter.deleteItem(position)
                    true
                }
                else -> false
            }
        }
        popup.show()
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