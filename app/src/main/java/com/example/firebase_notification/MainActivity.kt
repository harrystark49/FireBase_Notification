package com.example.firebase_notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


//if 2 files found with path 'META-INF/DEPENDENCIES'. this error comes add the package options in build gradle
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}