package com.example.apkdata

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.apkdata.data.AppDatabase
import com.example.apkdata.data.entity.User2

class buatdatacuy : AppCompatActivity() {

    private var visibilityFlag = false
    private lateinit var juduldata: EditText
    private lateinit var namadataangka: EditText
    private lateinit var masukanangka1: EditText
    private lateinit var masukanangka2: EditText
    private lateinit var jeniskategori: EditText
    private lateinit var jeniskategori2: EditText
    private lateinit var jeniskategori3: EditText
    private lateinit var namakategoricuy2: EditText
    private lateinit var namakategoricuy3: EditText
    private lateinit var namakategoricuy4: EditText
    private lateinit var namakategoricuy5: EditText
    private lateinit var namakategoricuy6: EditText
    private lateinit var namakategoricuy7: EditText
    private lateinit var save: Button
    private lateinit var database2: AppDatabase

    @SuppressLint("MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buatdatacuy)

        juduldata = findViewById(R.id.juduldata)
        namadataangka = findViewById(R.id.namadataangka)
        masukanangka1 = findViewById(R.id.masukanangka1)
        masukanangka2 = findViewById(R.id.masukanangka2)
        jeniskategori = findViewById(R.id.jeniskategori)
        jeniskategori2 = findViewById(R.id.jeniskategori2)
        jeniskategori3 = findViewById(R.id.jeniskategori3)
        namakategoricuy2 = findViewById(R.id.namakategoricuy2)
        namakategoricuy3 = findViewById(R.id.namakategoricuy3)
        namakategoricuy4 = findViewById(R.id.namakategoricuy4)
        namakategoricuy5 = findViewById(R.id.namakategoricuy5)
        namakategoricuy6 = findViewById(R.id.namakategoricuy6)
        namakategoricuy7 = findViewById(R.id.namakategoricuy7)
        save = findViewById(R.id.save)

        database2 = AppDatabase.getinstance(applicationContext)

        val intent2 = intent.extras
        if (intent2!=null){
            val id2 = intent2.getInt("id", 0)
            val user2 = database2.userDao().get2(id2)

            juduldata.setText(user2.juduldata)
            masukanangka1.setText(user2.masukanangka1.toString())
            namadataangka.setText(user2.namadataangka)
            jeniskategori.setText(user2.jeniskategori)
            jeniskategori2.setText(user2.jeniskategori2)
            jeniskategori3.setText(user2.jeniskategori3)
            namakategoricuy2.setText(user2.namakategoricuy2)
            namakategoricuy3.setText(user2.namakategoricuy3)
            namakategoricuy4.setText(user2.namakategoricuy4)
            namakategoricuy5.setText(user2.namakategoricuy5)
            namakategoricuy6.setText(user2.namakategoricuy6)
            namakategoricuy7.setText(user2.namakategoricuy7)
        }

        val textView = findViewById<TextView>(R.id.tamabahineditdata)
        textView.setOnClickListener {
            visibilityFlag = !visibilityFlag
            namakategoricuy3.visibility = if (visibilityFlag) View.VISIBLE else View.VISIBLE
        }
        val munculin5 = findViewById<TextView>(R.id.tamabahineditdata2)
        munculin5.setOnClickListener {
            visibilityFlag = !visibilityFlag
            namakategoricuy5.visibility = if (visibilityFlag) View.VISIBLE else View.VISIBLE
        }
        val munculin7 = findViewById<TextView>(R.id.tamabahineditdata3)
        munculin7.setOnClickListener {
            visibilityFlag = !visibilityFlag
            namakategoricuy7.visibility = if (visibilityFlag) View.VISIBLE else View.VISIBLE
        }
        save.setOnClickListener {
            if (juduldata.text.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Mohon Masukan Judul Data Anda",
                    Toast.LENGTH_SHORT
                ).show()
            }else if (jeniskategori2.text.isEmpty() && jeniskategori3.text.isNotEmpty()){
                Toast.makeText(
                    applicationContext,
                    "Mohon Masukan Kategori Berurutan",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (intent2 != null) {
                    //coding edit data
                    database2.userDao().update2(User2(
                        intent2.getInt("id", 0),
                        juduldata.text.toString(),
                        masukanangka1.text.toString().toIntOrNull() ?: 0,
                        masukanangka2.text.toString().toIntOrNull() ?: 0,
                        namadataangka.text.toString(),
                        jeniskategori.text.toString(),
                        jeniskategori2.text.toString(),
                        jeniskategori3.text.toString(),
                        namakategoricuy2.text.toString(),
                        namakategoricuy3.text.toString(),
                        namakategoricuy4.text.toString(),
                        namakategoricuy5.text.toString(),
                        namakategoricuy6.text.toString(),
                        namakategoricuy7.text.toString(),
                    )
                    )
                    Toast.makeText(
                        applicationContext,
                        "Data Telah Diupdate",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    database2.userDao().insertAll2(User2(
                        null,
                        juduldata.text.toString(),
                        masukanangka1.text.toString().toIntOrNull() ?: 0,
                        masukanangka2.text.toString().toIntOrNull() ?: 0,
                        namadataangka.text.toString(),
                        jeniskategori.text.toString(),
                        jeniskategori2.text.toString(),
                        jeniskategori3.text.toString(),
                        namakategoricuy2.text.toString(),
                        namakategoricuy3.text.toString(),
                        namakategoricuy4.text.toString(),
                        namakategoricuy5.text.toString(),
                        namakategoricuy6.text.toString(),
                        namakategoricuy7.text.toString(),
                    )
                    )
                    Toast.makeText(
                        applicationContext,
                        "Data Telah Ditambahkan",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}