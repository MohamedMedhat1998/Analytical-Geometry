package com.andalus.abo_med7at.analyticalgeometry.services

import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.andalus.abo_med7at.analyticalgeometry.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

private const val NOTIFICATION_ID = 5
private const val REQUEST_CODE = 9
private const val NOTIFICATION_CHANNEL = "analytical-geometry-update-channel"

class NotificationService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)
        sendNotification(remoteMessage?.notification?.title, remoteMessage?.notification?.body)
    }

    private fun sendNotification(title: String?, text: String?) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(getString(R.string.update_link))
        val pendingIntent = PendingIntent.getActivity(applicationContext, REQUEST_CODE, intent, PendingIntent.FLAG_ONE_SHOT)

        val builder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(text)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
        with(NotificationManagerCompat.from(this)) {
            notify(NOTIFICATION_ID, builder.build())
        }
    }
}