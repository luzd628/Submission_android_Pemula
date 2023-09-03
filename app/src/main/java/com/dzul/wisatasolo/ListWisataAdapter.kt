package com.dzul.wisatasolo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListWisataAdapter(
    private val listwisata: MutableList<wisata>,
    val listener : (wisata)-> Unit
) : RecyclerView.Adapter<ListWisataAdapter.ViewHolder>(){

    class ViewHolder(private  val v :View) : RecyclerView.ViewHolder(v) {
        private val gambar:ImageView = v.findViewById(R.id.img_item_photo)
        private val judul:TextView = v.findViewById(R.id.tv_item_name)
        private val deskripsi:TextView = v.findViewById(R.id.tv_item_description)


        fun onBind(data: wisata,listner:(wisata) -> Unit){
            this.judul.text = data.judul
            this.deskripsi.text = data.deskripsi
            this.gambar.setImageResource(data.photo)
            itemView.setOnClickListener{listner(data)}
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =  LayoutInflater.from(parent.context).inflate(R.layout.item_row_wisata,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount():Int = listwisata.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listwisata[position],listener)

    }



}

