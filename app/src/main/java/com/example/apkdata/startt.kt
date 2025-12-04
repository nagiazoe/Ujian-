package com.example.apkdata

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.apkdata.data.AppDatabase
import com.example.apkdata.data.entity.User

class startt : AppCompatActivity() {

    private lateinit var namakategoristart2: EditText
    private lateinit var namakategoristart3: EditText
    private lateinit var namakategoristart4: EditText
    private lateinit var namakategoristart5: EditText
    private lateinit var nama: EditText
    private lateinit var dataangkastart: EditText
    private lateinit var namaketegoristart: EditText
    private lateinit var add: Button
    private lateinit var database: AppDatabase

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startt)

        nama = findViewById(R.id.nama)
        dataangkastart = findViewById(R.id.dataangkastart)
        namaketegoristart = findViewById(R.id.namaketegoristart)
        namakategoristart2 = findViewById(R.id.namakategoristart2)
        namakategoristart3 = findViewById(R.id.namakategoristart3)
        namakategoristart4 = findViewById(R.id.namakategoristart4)
        namakategoristart5 = findViewById(R.id.namakategoristart5)
        add = findViewById(R.id.add)

        database = AppDatabase.getinstance(applicationContext)

        val intent = intent.extras
        if (intent!=null){

            val id = intent.getInt("id", 0)
            val user = database.userDao().get(id)

            nama.setText(user.nama)
            dataangkastart.setText(user.dataangkastart.toString())
            namaketegoristart.setText(user.namaketegoristart)
            namakategoristart2.setText(user.namaketegoristart2)
            namakategoristart3.setText(user.namaketegoristart3)
            namakategoristart4.setText(user.namaketegoristart4)
            namakategoristart5.setText(user.namaketegoristart5)
        }
        val jaenal = findViewById<TextView>(R.id.plus2)
        var visibilityFlag1 = false
        var visibilityFlag2 = false
        var visibilityFlag3 = false

        jaenal.setOnClickListener {
            if (!visibilityFlag1) {
                namakategoristart2.visibility = View.VISIBLE
                visibilityFlag1 = true
            } else if (!visibilityFlag2) {
                namakategoristart3.visibility = View.VISIBLE
                visibilityFlag2 = true
            } else if (!visibilityFlag3) {
                namakategoristart4.visibility = View.VISIBLE
                visibilityFlag3 = true
            } else {
                namakategoristart5.visibility = View.VISIBLE
            }
        }
        add.setOnClickListener {
            if (nama.text.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Mohon Masukan Nama Data Anda",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (namakategoristart2.text.isEmpty() && namakategoristart3.text.isNotEmpty() || namakategoristart4.text.isNotEmpty() || namakategoristart5.text.isNotEmpty()){
                Toast.makeText(
                    applicationContext,
                    "Mohon Masukan Kategori Berurutan",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (namakategoristart3.text.isEmpty() && namakategoristart4.text.isNotEmpty() || namakategoristart5.text.isNotEmpty()){
                Toast.makeText(
                    applicationContext,
                    "Mohon Masukan Kategori Berurutan",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (namakategoristart4.text.isEmpty() && namakategoristart5.text.isNotEmpty()){
                Toast.makeText(
                    applicationContext,
                    "Mohon Masukan Kategori Berurutan",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                    if (intent != null) {
                        //coding edit data
                        database.userDao().update(
                            User(
                                intent.getInt("id", 0),
                                nama.text.toString(),
                                dataangkastart.text.toString().toIntOrNull() ?: 0,
                                namaketegoristart.text.toString(),
                                namakategoristart2.text.toString(),
                                namakategoristart3.text.toString(),
                                namakategoristart4.text.toString(),
                                namakategoristart5.text.toString()
                            )
                        )
                        Toast.makeText(
                            applicationContext,
                            "Data Telah Diupdate",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        //coding tambah data
                        database.userDao().insertAll(
                            User(
                                null,
                                nama.text.toString(),
                                dataangkastart.text.toString().toIntOrNull() ?: 0,
                                namaketegoristart.text.toString(),
                                namakategoristart2.text.toString(),
                                namakategoristart3.text.toString(),
                                namakategoristart4.text.toString(),
                                namakategoristart5.text.toString()
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
