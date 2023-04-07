package com.example.allttaemerona.src.main.purchaser.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.allttaemerona.databinding.ItemRequestBinding
import com.example.allttaemerona.src.main.purchaser.list.models.RequestItem

class RequestItemRVAdapter(private val requestDataList: ArrayList<RequestItem>): RecyclerView.Adapter<RequestItemRVAdapter.RequestItemViewHolder>() {
    inner class RequestItemViewHolder(private val viewBinding: ItemRequestBinding): RecyclerView.ViewHolder(viewBinding.root) {
        val ibMenu = viewBinding.ibMenu

        fun bind(data: RequestItem){
            if (data.image != ""){
                viewBinding.ivItem.setImageURI(data.image.toUri())
            }
            viewBinding.tvItemAddress.text = data.address
            viewBinding.tvItemTime.text = data.time.toString()
            viewBinding.tvItemDeliveryPay.text = data.deliveryPay.toString()
            viewBinding.tvItemProduct.text = data.product

            viewBinding.ivItem.clipToOutline = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestItemViewHolder {
        val viewBinding = ItemRequestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RequestItemViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: RequestItemViewHolder, position: Int) {
        holder.bind(requestDataList[position])
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(it, position)
        }
        holder.ibMenu.setOnClickListener {
            itemClickListener.onMenuClick(it, position)
        }
    }

    fun deleteItem(position: Int){
        requestDataList.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int = requestDataList.size

    interface OnItemClickListener {
        fun onItemClick(v: View, position: Int)
        fun onMenuClick(v: View, position: Int)
    }
    fun setItemClickListener(onItemClickListener: OnItemClickListener){
        this.itemClickListener = onItemClickListener
    }
    private lateinit var itemClickListener: OnItemClickListener
}