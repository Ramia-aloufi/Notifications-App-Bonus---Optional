package com.example.notificationsappbonus_optional

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService

class NotifiNotification {

    private lateinit var builder: Notification.Builder
    private val channelId = "myapp.notifications"
    private val description = "Notification App Example"
    lateinit var notificationManager: NotificationManager
    lateinit var pendingIntent: PendingIntent

    fun notification(text: String,context: Context){
        val intent = Intent(context, MainActivity2::class.java)
        pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var notificationChannel = NotificationChannel(channelId,description,
                NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
            builder = Notification.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .setContentTitle("My Notification")
                .setContentText(text)
        }
        else {
            builder = Notification.Builder(context)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .setContentTitle("My Notification")
                .setContentText("Hello")
        }
        notificationManager.notify(1234, builder.build())
    }
}