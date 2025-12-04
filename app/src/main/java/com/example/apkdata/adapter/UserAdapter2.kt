package com.example.apkdata.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apkdata.R
import com.example.apkdata.TampilinFullBuatDataCuyLand
import com.example.apkdata.data.entity.User2

class UserAdapter2(var list2: List<User2>) : RecyclerView.Adapter<UserAdapter2.ViewHolder2>(){

    private lateinit var dialog: Dialog
    fun setDialog2(dialog: Dialog){
        this.dialog = dialog
    }
    interface Dialog {
        fun onClick(position: Int)
    }

    inner class ViewHolder2 (view2: View) : RecyclerView.ViewHolder(view2) {
        var juduldata: TextView = view2.findViewById(R.id.juduldata)

        init {
            juduldata = view2.findViewById(R.id.juduldata)
            view2.setOnLongClickListener {
                dialog.onClick(layoutPosition)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter2.ViewHolder2 {
        val view2 = LayoutInflater.from(parent.context).inflate(R.layout.tampilanbuatdatacuy, parent, false)
        return ViewHolder2(view2)
    }

    override fun getItemCount(): Int {
        return list2.size
    }

    override fun onBindViewHolder(holder: ViewHolder2, position: Int) {
        holder.juduldata.text = list2[position].juduldata?.uppercase()

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, TampilinFullBuatDataCuyLand::class.java)
            intent.putExtra("namadataangka", list2[position].namadataangka)
            intent.putExtra("jeniskategori", list2[position].jeniskategori)
            intent.putExtra("jeniskategori2", list2[position].jeniskategori2)
            intent.putExtra("jeniskategori3", list2[position].jeniskategori3)
            holder.itemView.context.startActivity(intent)
        }
    }
}
