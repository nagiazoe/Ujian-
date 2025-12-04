package com.example.apkdata.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apkdata.R
import com.example.apkdata.data.entity.User

class UserAdapter(var list: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    private lateinit var dialog: Dialog
    fun setDialog(dialog: Dialog){
        this.dialog = dialog
    }
    interface Dialog {
        fun onClick(position: Int)
    }

    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        var nama : TextView
        var dataangkastart : TextView
        var namaketegori : TextView
        var namakategori2 : TextView
        var namakategori3 : TextView
        var namakategori4 : TextView
        var namakategori5 : TextView

        init {
            nama = view.findViewById(R.id.nama)
            dataangkastart = view.findViewById(R.id.dataangkastart)
            namaketegori = view.findViewById(R.id.namaketegoristart)
            namakategori2 = view.findViewById(R.id.namakategoristart2)
            namakategori3 = view.findViewById(R.id.namakategoristart3)
            namakategori4 = view.findViewById(R.id.namakategoristart4)
            namakategori5 = view.findViewById(R.id.namakategoristart5)
            view.setOnLongClickListener {
                dialog.onClick(layoutPosition)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tampilandatastart, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nama.text = list[position].nama?.uppercase()
        holder.dataangkastart.text = list[position].dataangkastart.toString()
        holder.namaketegori.text = list[position].namaketegoristart
        holder.namakategori2.text = list[position].namaketegoristart2
        holder.namakategori3.text = list[position].namaketegoristart3
        holder.namakategori4.text = list[position].namaketegoristart4
        holder.namakategori5.text = list[position].namaketegoristart5
    }
}