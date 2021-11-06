package com.example.notificationsappbonus_optional

import android.app.Notification
import android.app.NotificationManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button

lateinit var btn:Button
lateinit var Noti:NotifiNotification
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Noti  = NotifiNotification()

        btn = findViewById(R.id.button)

        btn.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                Noti.notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                Noti.notification("Your Order redy!",this)
            }, 3000)
        }


    }
}