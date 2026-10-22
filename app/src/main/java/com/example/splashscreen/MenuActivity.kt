package com.example.splashscreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_menu)

        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v, insets ->

            val systemBars =
                insets.getInsets(
                    WindowInsetsCompat.Type.systemBars()
                )

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        findViewById<Button>(R.id.button_simpan1).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        findViewById<Button>(R.id.button_simpanBanyak).setOnClickListener {
            startActivity(Intent(this, MultiDataActivity::class.java))
        }

        findViewById<Button>(R.id.button_listView).setOnClickListener {
            startActivity(Intent(this, ListViewActivity::class.java))
        }

        findViewById<Button>(R.id.button_recycleView).setOnClickListener {
            startActivity(Intent(this, RecycleViewActivity::class.java))
        }
    }
}
