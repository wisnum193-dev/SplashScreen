package com.example.splashscreen

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private val PREF_NAME = "MyUserPrefs"
    private val KEY_NAMA = "KEY_NAMA_USER"

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        val etNama = findViewById<EditText>(R.id.etNama)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)
        val btnMuat = findViewById<Button>(R.id.btnMuat)
        val btnHapus = findViewById<Button>(R.id.btnHapus)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        if (!sharedPreferences.contains(KEY_NAMA)) {
            sharedPreferences.edit()
                .putString(
                    KEY_NAMA,
                    "Ahmad Fauzi (Data Default)"
                )
                .apply()
        }

        val namaAwal = sharedPreferences.getString(KEY_NAMA, null)
        if (namaAwal != null) {
            tvHasil.text = "Selamat Datang Kembali: $namaAwal"
        }

        btnSimpan.setOnClickListener {
            val inputNama = etNama.text.toString()

            if (inputNama.isNotEmpty()) {
                val editor = sharedPreferences.edit()
                editor.putString(KEY_NAMA, inputNama)
                editor.apply()

                Toast.makeText(
                    this,
                    "Data berhasil disimpan!",
                    Toast.LENGTH_SHORT
                ).show()

                etNama.text.clear()
            } else {
                Toast.makeText(
                    this,
                    "Silahkan isi nama terlebih dahulu",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btnMuat.setOnClickListener {
            val dataTersimpan = sharedPreferences.getString(KEY_NAMA, null)

            if (!dataTersimpan.isNullOrEmpty()) {
                tvHasil.text = "Selamat Datang Kembali: $dataTersimpan"

                Toast.makeText(
                    this,
                    "Data berhasil dimuat!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                tvHasil.text = "[Data tidak ditemukan]"

                Toast.makeText(
                    this,
                    "Data tidak ditemukan",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btnHapus.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.remove(KEY_NAMA)
            editor.apply()

            tvHasil.text = "[Data telah dihapus]"

            Toast.makeText(
                this,
                "Data berhasil dihapus",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
