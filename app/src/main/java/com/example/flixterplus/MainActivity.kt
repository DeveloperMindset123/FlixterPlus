package com.example.flixterplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flixterplus.R.id

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val supportFragmentManager = supportFragmentManager  //a getter function to retrieve the fragment
        val fragmentTransaction = supportFragmentManager.beginTransaction()  //requires a commit call for the transaction to be valid
        fragmentTransaction.replace(id.content, LatestMoviesFragment(), null).commit()  //id.content points to the FrameLayout view in activity_main

    }
}