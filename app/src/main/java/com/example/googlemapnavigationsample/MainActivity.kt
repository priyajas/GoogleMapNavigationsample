package com.example.googlemapnavigationsample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.googlemapnavigationsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.navButton.setOnClickListener {
            val source = binding.source.text.toString()
            val destination = binding.destination.text.toString()
            if (source.isEmpty() || destination.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please enter both source and destination for navigation",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val uri = Uri.parse("https://www.google.com/maps/dir/$source/$destination")
                val mapIntent = Intent(Intent.ACTION_VIEW, uri)
                mapIntent.setPackage("com.google.android.apps.maps")
                if (mapIntent.resolveActivity(packageManager) != null) {
                    startActivity(mapIntent);
                }
            }
        }
    }
}