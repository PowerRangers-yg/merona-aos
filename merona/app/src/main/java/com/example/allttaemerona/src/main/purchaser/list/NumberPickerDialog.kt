package com.example.allttaemerona.src.main.purchaser.list

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.allttaemerona.databinding.DialogNumberPickerBinding

class NumberPickerDialog(
    private val dialogTitle: String,
    var initNum: Int,
    var maxV: Int,
    var minV: Int,
    var step: Int
    ) : DialogFragment() {
    private lateinit var listener: DialogOkClickedListener
    private var _binding: DialogNumberPickerBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogNumberPickerBinding.inflate(inflater, container, false)
        val view = binding.root
        val numberPicker = binding.npTime
        val title = binding.tvPickerTitle
        var valueList : List<Int> = IntRange(minV, maxV).step(step).toList()
        var valueConvert = valueList.map { it.toString() }

        title.text = dialogTitle

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        numberPicker.minValue = minV
        numberPicker.maxValue = (maxV - minV) / step
        numberPicker.value = initNum/step
        numberPicker.displayedValues = valueConvert.toTypedArray()

        binding.btnPickerCancel.setOnClickListener {
            dismiss()
        }

        binding.btnPickerOk.setOnClickListener {
            listener.onOkClicked(numberPicker.value * step)
            dismiss()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setOnOkClickedListener(listenr: (Int) -> Unit){
        this.listener = object : DialogOkClickedListener {
            override fun onOkClicked(content: Int) {
                listenr(content)
            }
        }
    }

    interface DialogOkClickedListener {
        fun onOkClicked(content: Int)
    }
}