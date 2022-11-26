package com.example.usespermission2611

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn= findViewById<Button>(R.id.button)
        var btn2 = findViewById<Button>(R.id.button2)

        var x = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it)
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
        btn.setOnClickListener {
            x.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        btn2.setOnClickListener {
            x.launch(android.Manifest.permission.CAMERA)
        }
    }
}