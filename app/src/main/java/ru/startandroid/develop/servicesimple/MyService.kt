package ru.startandroid.develop.servicesimple

import android.content.Intent
import android.os.IBinder
import android.util.Log


const val LOG_TAG = "myLogs"

class MyService : android.app.Service() {
    override fun onCreate() {
        super.onCreate()
        Log.d(LOG_TAG, "onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(LOG_TAG, "onStartCommand")
        someTask()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }

    override fun onBind(p0: Intent?): IBinder? {
        Log.d(LOG_TAG, "onBind")
        return null
    }
    private fun someTask() {
        Thread {
            for (i in 1..5) {
                Log.d(LOG_TAG, "i = $i")
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            stopSelf()
        }.start()
    }
}