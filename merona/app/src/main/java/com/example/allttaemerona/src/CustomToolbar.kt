package com.example.allttaemerona.src

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.allttaemerona.R

class CustomToolbar(context: Context, attrs:AttributeSet) : ConstraintLayout(context,attrs) {

    private var showBackButton : Boolean = false
    private lateinit var title: String
    init {
        initAttrs(attrs)
        initView()
    }

    private fun initAttrs(attrs: AttributeSet){
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomToolbar,
            0, 0
        ).apply {
            try {
                showBackButton = getBoolean(R.styleable.CustomToolbar_showBackButton, false)
                title = getString(R.styleable.CustomToolbar_title) ?: ""
            } finally {
                recycle()
            }
        }
    }

    private fun initView() {
        inflate(context, R.layout.custom_toolbar, this)

        val titleTextView = findViewById<TextView>(R.id.tv_title)
        val backButton = findViewById<ImageButton>(R.id.ib_back)

        titleTextView.text = title
        if(!showBackButton) backButton.visibility = View.GONE
    }

    fun setOnBackListner(listner: OnBackListener){
        val backButton = findViewById<ImageButton>(R.id.ib_back)
        backButton.setOnClickListener {
            listner.onClick(it)
        }
    }

    fun setOnBackListener(action: (view: View) -> Unit){
        val backButton = findViewById<ImageButton>(R.id.ib_back)
        backButton.setOnClickListener {
            action(it)
        }
    }

    interface OnBackListener {
        fun onClick(view: View)
    }
}