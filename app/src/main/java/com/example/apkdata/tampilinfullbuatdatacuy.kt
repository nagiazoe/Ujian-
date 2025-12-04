package com.example.apkdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TampilinFullBuatDataCuyLand : AppCompatActivity() {

    private lateinit var namadataangka: TextView
    private lateinit var jeniskategori: TextView
    private lateinit var jeniskategori2: TextView
    private lateinit var jeniskategori3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tampilinfullbuatdatacuy)

        namadataangka = findViewById(R.id.namadataangka)
        jeniskategori = findViewById(R.id.jeniskategori)
        jeniskategori2 = findViewById(R.id.jeniskategori2)
        jeniskategori3 = findViewById(R.id.jeniskategori3)

        val intent = intent
        if (intent != null) {
            namadataangka.text = intent.getStringExtra("namadataangka")
            jeniskategori.text = intent.getStringExtra("jeniskategori")
            jeniskategori2.text = intent.getStringExtra("jeniskategori2")
            jeniskategori3.text = intent.getStringExtra("jeniskategori3")
        }
    }
}