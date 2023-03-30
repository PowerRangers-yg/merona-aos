package com.example.allttaemerona.src

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ContentInfoCompat.Flags
import com.example.allttaemerona.R
import com.example.allttaemerona.src.main.purchaser.list.RequestListFragment

class CustomToolbar(context: Context, attrs:AttributeSet) : ConstraintLayout(context,attrs) {

    private var showBackButton : Boolean = false
    private var showButtons : Boolean = true
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
                showButtons = getBoolean(R.styleable.CustomToolbar_showButtons, true)
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
        val switchButton = findViewById<ImageButton>(R.id.ib_switch)
        val notificationButton = findViewById<ImageButton>(R.id.ib_notification)
        val settingButton = findViewById<ImageButton>(R.id.ib_setting)

        titleTextView.text = title
        if(!showBackButton) backButton.visibility = View.GONE
        if(!showButtons) {
            switchButton.visibility = View.GONE
            notificationButton.visibility = View.GONE
            settingButton.visibility = View.GONE
        }
    }

    fun setOnBackListener(listener: OnBackListener){
        val backButton = findViewById<ImageButton>(R.id.ib_back)
        backButton.setOnClickListener {
            listener.onClick(it)
        }
    }

    fun setOnBackListener(action: (view: View) -> Unit){
        val backButton = findViewById<ImageButton>(R.id.ib_back)
        backButton.setOnClickListener {
            action(it)
        }
    }

    fun setOnSwitchListener(listener: OnSwitchListener){
        val switchButton = findViewById<ImageButton>(R.id.ib_switch)
        switchButton.setOnClickListener {
            listener.onClick(it)
        }
    }

    fun setOnSwitchListener(action: (view: View) -> Unit){
        val switchButton = findViewById<ImageButton>(R.id.ib_switch)
        switchButton.setOnClickListener {
            action(it)
        }
    }

    fun setOnNotiListener(listener: OnNotiListener){
        val switchButton = findViewById<ImageButton>(R.id.ib_notification)
        switchButton.setOnClickListener {
            listener.onClick(it)
        }
    }

    fun setOnNotiListener(action: (view: View) -> Unit){
        val switchButton = findViewById<ImageButton>(R.id.ib_notification)
        switchButton.setOnClickListener {
            action(it)
        }
    }

    fun setOnSettingListener(listener: OnSettingListener){
        val switchButton = findViewById<ImageButton>(R.id.ib_setting)
        switchButton.setOnClickListener {
            listener.onClick(it)
        }
    }

    fun setOnSettingListener(action: (view: View) -> Unit){
        val switchButton = findViewById<ImageButton>(R.id.ib_setting)
        switchButton.setOnClickListener {
            action(it)
        }
    }

    interface OnBackListener {
        fun onClick(view: View)
    }

    interface OnSwitchListener {
        fun onClick(view: View)
    }

    interface OnNotiListener {
        fun onClick(view: View)
    }

    interface OnSettingListener {
        fun onClick(view: View)
    }

}