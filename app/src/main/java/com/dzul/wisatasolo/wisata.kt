package com.dzul.wisatasolo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class wisata(
    val judul : String,
    val deskripsi : String,
    val lokasi : String,
    val photo : Int
):Parcelable
