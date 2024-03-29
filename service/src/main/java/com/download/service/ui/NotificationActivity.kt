package com.download.service.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.download.service.databinding.ActivityNotificationBinding
import com.download.service.notifs.PreOreoNotificationBuilder
import com.download.service.notifs.ProgressNotificationBuilder
import com.download.service.notifs.SafeNotificationBuilder

class NotificationActivity : AppCompatActivity() {

    companion object {
        const val CHANNEL_1_ID = "CHANNEL_1_ID"
        const val CHANNEL_2_ID = "CHANNEL_2_ID"
    }

    private val binding by lazy {
        ActivityNotificationBinding.inflate(layoutInflater)
    }

    private val safeNotificationBuilder by lazy {
        SafeNotificationBuilder(
            ProgressNotificationBuilder(this),
            PreOreoNotificationBuilder(this)
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setClickListeners()
    }

    private fun setClickListeners() {
        with(binding) {
            btnCreateChannel.setOnClickListener {
                safeNotificationBuilder.createChannel(this@NotificationActivity)
            }

            btnShowNotif.setOnClickListener {
                safeNotificationBuilder.createNotification(this@NotificationActivity)
            }
        }
    }


}