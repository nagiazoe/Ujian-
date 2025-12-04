package com.example.apkdata

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class tampilandua : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnImageButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tampilandua)

        btnImageButton = findViewById(R.id.buatdata)
        btnImageButton.setOnClickListener(this)

        btnImageButton = findViewById(R.id.start)
        btnImageButton.setOnClickListener(this)

        btnImageButton = findViewById(R.id.LiatData)
        btnImageButton.setOnClickListener(this)

        btnImageButton = findViewById(R.id.hasildata)
        btnImageButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.buatdata -> {
                    val pindah = Intent(this@tampilandua, buatdatacuy::class.java)
                    startActivity(pindah)
                }
            }
        }
        if (v != null) {
            when (v.id) {
                R.id.start -> {
                    val joyco = Intent(this@tampilandua, startt::class.java)
                    startActivity(joyco)
                }
            }
        }
        if (v != null) {
            when (v.id) {
                R.id.LiatData -> {
                    val oke = Intent(this@tampilandua, Lihatdata::class.java)
                    startActivity(oke)
                }
            }
        }
        if (v != null) {
            when (v.id) {
                R.id.hasildata -> {
                    val aichan = Intent(this@tampilandua, liatdata::class.java)
                    startActivity(aichan)
                }
            }
        }
    }
}