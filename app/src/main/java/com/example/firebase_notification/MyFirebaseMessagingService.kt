package com.example.firebase_notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val channelId="notification"
class MyFirebaseMessagingService:FirebaseMessagingService() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        if(message.notification!=null){

            generateNotification(message.notification!!.title!!,message.notification!!.body!!)
        }
    }



    @RequiresApi(Build.VERSION_CODES.O)
    fun generateNotification(title:String,msg:String){

        var intent=Intent(this,MainActivity::class.java)
        intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK

        var pendingintent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT)

        var builder=NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.gcm_icon)
            .setAutoCancel(true)
            .setOnlyAlertOnce(true)
            .setVibrate(longArrayOf(1000,1000,1000,1000))
            .setContentTitle(title)
            .setSubText(msg)
            .setContentIntent(pendingintent)

        var notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        var notificationChannel=NotificationChannel(channelId,"notify",NotificationManager.IMPORTANCE_DEFAULT)
        notificationManager.createNotificationChannel(notificationChannel)

        notificationManager.notify(1,builder.build())


    }
}