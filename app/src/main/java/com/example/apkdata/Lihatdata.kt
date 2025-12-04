package com.example.apkdata

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.apkdata.adapter.UserAdapter
import com.example.apkdata.data.AppDatabase
import com.example.apkdata.data.entity.User


class Lihatdata : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserAdapter
    private var list = mutableListOf<User>()
    private lateinit var database: AppDatabase
    private lateinit var searchlihatdatastart : EditText
    private lateinit var buttonsearch : Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lihatdata)

        recyclerView = findViewById(R.id.recycler_view)
        adapter = UserAdapter(list)
        database = AppDatabase.getinstance(applicationContext)

        searchlihatdatastart = findViewById (R.id.searchlihatdatastart)
        buttonsearch = findViewById(R.id.buttonsearch)

        buttonsearch.setOnClickListener {
            if (searchlihatdatastart.text.isNotEmpty()) {
                searhdatanama(searchlihatdatastart.text.toString())
            } else {
                getData()
            }
        }
        searchlihatdatastart.setOnKeyListener { v, keyCode, event ->
            if (searchlihatdatastart.text.isNotEmpty()) {
                searhdatanama(searchlihatdatastart.text.toString())
            } else {
                getData()
            }
            false
        }
        // tambahkan kode ini untuk menangani long click pada item RecyclerView
        adapter.setDialog(object : UserAdapter.Dialog{
            override fun onClick(position: Int) {
                val user = list[position]
                val dialog = AlertDialog.Builder(this@Lihatdata)
                dialog.setTitle(user.nama)
                dialog.setItems(R.array.item_option) { _, which ->
                    when (which) {
                        0 -> {
                            val intent = Intent(this@Lihatdata, startt::class.java)
                            intent.putExtra("id", user.uid)
                            startActivity(intent)
                        }
                        1 -> {
                            val alertDialog = AlertDialog.Builder(this@Lihatdata)
                            alertDialog.setTitle("Hapus Data")
                            alertDialog.setMessage("Apakah Anda Yakin Ingin Menghapus Data ${user.nama}?")
                            alertDialog.setPositiveButton("Ya") { _, _ ->
                                database.userDao().delete(user)
                                list.remove(user)
                                adapter.notifyDataSetChanged()
                            }
                            alertDialog.setNegativeButton("Tidak") { dialog, _ ->
                                dialog.dismiss()
                            }
                            alertDialog.show()
                        }
                    }
                }
                dialog.show()
            }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext, VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(applicationContext, VERTICAL))
    }


    override fun onResume() {
        super.onResume()
        getData()
    }
    @SuppressLint("NotifyDataSetChanged")
    fun getData() {
        list.clear()
        list.addAll(database.userDao().getAll())
        adapter.notifyDataSetChanged()
    }
    @SuppressLint("NotifyDataSetChanged")
    fun searhdatanama(search : String) {
        list.clear()
        list.addAll(database.userDao().searchbynama(search))
        list.addAll(database.userDao().searchbydataangka(search))
        list.addAll(database.userDao().searchbynamakategori(search))
        list.addAll(database.userDao().searchbynamakategori2(search))
        list.addAll(database.userDao().searchbynamakategori3(search))
        list.addAll(database.userDao().searchbynamakategori4(search))
        list.addAll(database.userDao().searchbynamakategori5(search))
        adapter.notifyDataSetChanged()
    }
}