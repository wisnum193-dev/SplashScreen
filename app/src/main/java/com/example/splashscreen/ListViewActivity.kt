package com.example.splashscreen

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        val listView = findViewById<ListView>(R.id.listView)
        val sampleContacts = arrayOf(
            "Andi - 08123456789",
            "Budi - 08234567890",
            "Citra - 08345678901",
            "Dewi - 08456789012",
            "Eko - 08567890123"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sampleContacts)
        listView.adapter = adapter
    }
}
