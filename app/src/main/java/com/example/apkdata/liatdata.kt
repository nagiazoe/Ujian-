package com.example.apkdata

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apkdata.adapter.UserAdapter
import com.example.apkdata.adapter.UserAdapter2
import com.example.apkdata.data.AppDatabase
import com.example.apkdata.data.entity.User2



class liatdata : AppCompatActivity() {

    private lateinit var recyclerView2: RecyclerView
    private var list2 = mutableListOf <User2>()
    private lateinit var adapter2: UserAdapter2
    lateinit var database2: AppDatabase
    private lateinit var searchliatdata : EditText
    private lateinit var buttonsearchcuy : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //create data
        setContentView(R.layout.activity_liatdata)

        adapter2 = UserAdapter2(list2)
        database2 = AppDatabase.getinstance(applicationContext)
        searchliatdata = findViewById (R.id.searchliatdata)
        buttonsearchcuy = findViewById(R.id.buttonsearchcuy)

        buttonsearchcuy.setOnClickListener {
            if (searchliatdata.text.isNotEmpty()) {
                searchcuy(searchliatdata.text.toString())
            } else {
                getdata2()
            }
        }
        searchliatdata.setOnKeyListener { v, keyCode, event ->
            if (searchliatdata.text.isNotEmpty()) {
                searchcuy(searchliatdata.text.toString())
            } else {
                getdata2()
            }
            false
        }

        adapter2.setDialog2(object : UserAdapter2.Dialog{
            override fun onClick(position: Int) {
                val user2 = list2[position]
                val dialog = AlertDialog.Builder(this@liatdata)
                dialog.setTitle(user2.juduldata?.uppercase())
                dialog.setItems(R.array.item_option) { _, which ->
                    when (which) {
                        0 -> {
                            val intent = Intent(this@liatdata, buatdatacuy::class.java)
                            intent.putExtra("id", user2.id2)
                            startActivity(intent)
                        }
                        1 -> {
                            val alertDialog = AlertDialog.Builder(this@liatdata)
                            alertDialog.setTitle("Hapus Data")
                            alertDialog.setMessage("Apakah Anda Yakin Ingin Menghapus Data ${user2.juduldata}?")
                            alertDialog.setPositiveButton("Ya") { _, _ ->
                                database2.userDao().delete(user2)
                                list2.remove(user2)
                                adapter2.notifyDataSetChanged()
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

        recyclerView2 = findViewById(R.id.recycler_view2)
        recyclerView2.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        recyclerView2.addItemDecoration(DividerItemDecoration(applicationContext, RecyclerView.VERTICAL))
        recyclerView2.adapter = adapter2

    }

    override fun onResume() {
        super.onResume()
        getdata2()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getdata2 (){
        list2.clear()
        list2.addAll(database2.userDao().getAll2())
        adapter2.notifyDataSetChanged()
    }
    @SuppressLint("NotifyDataSetChanged")
    fun searchcuy (search : String){
        list2.clear()
        list2.addAll(database2.userDao().searchbyjuduldata(search))
        adapter2.notifyDataSetChanged()
    }
}
