package com.dzul.wisatasolo

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class DetailWisata : AppCompatActivity() {

    private lateinit var btnShare : Button

    companion object{
        const val EXTRA_WISATA = "extra_wisata"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_wisata)

        val wisata = intent.getParcelableExtra<wisata>(MainActivity.INTENT_PARCELABLE)

        //val Wisata = intent.getParcelableExtra<wisata>("wisata")

        val tvDetailNama = findViewById<TextView>(R.id.tvDetailNama)
        val tvDeskripsi = findViewById<TextView>(R.id.tvDeskripsi)
        val ivPhoto = findViewById<ImageView>(R.id.imageView)
        val tvlokasi  = findViewById<TextView>(R.id.tvLokasi)

        wisata?.photo?.let { ivPhoto.setImageResource(it) }
        tvDetailNama.text = wisata?.judul
        tvDeskripsi.text = wisata?.deskripsi
        tvlokasi.text = wisata?.lokasi


        btnShare = findViewById(R.id.btnShare)

        btnShare.setOnClickListener{

            val myDrawable = ivPhoto.drawable
            val nBitmap = (myDrawable as BitmapDrawable).bitmap

            val s = tvDeskripsi.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            val path = MediaStore.Images.Media.insertImage(contentResolver,nBitmap,"title",null)
            val uri = Uri.parse(path)

            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_STREAM,uri)
            intent.putExtra(Intent.EXTRA_TEXT,s)
            startActivity(Intent.createChooser(intent,"Share Via"))
        }

    }



}