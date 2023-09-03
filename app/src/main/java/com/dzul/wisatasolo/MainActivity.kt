package com.dzul.wisatasolo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var rvWisata: RecyclerView? = null

    companion object{
        val INTENT_PARCELABLE = "object_intent"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvWisata = findViewById(R.id.rv_wisata)
        //data isian aplikasi
        val wisatalist = mutableListOf<wisata>(
            wisata(
                "The Heritage Palace",
                "The Heritage Palace adalah tempat wisata Solo yang berlokasi di Honggobayan, Pabelan, Kartasura, Sukoharjo.Tempat ini dibuka sejak 9 Juni 2018.Di sini, kita bisa melihat beberapa bangunan bersejarah, mobil antik, museum 3D serta Omah Walik.Selain itu, kawasan wisata ini cocok untuk Moms dan keluarga mengambil potret liburan yang seru.The Heritage Palace buka setiap hari, Senin-Kamis pada pukul 10:00-18:00 WIB, Jumat-Minggu buka pukul 09:00-21:00.Harga tiket masuk Rp55.000 per orangnya.",
                "Honggobayan, Pabelan, Kartasura, Sukoharjo",
                R.drawable.heritage),
            wisata(
                "Keraton Surakarta Hadiningrat",
                "Keraton Surakarta Hadiningrat adalah tempat wisata Solo yang sudah sangat populer dan terkenal bagi para wisatawan dalam maupun luar negeri.Kita dapat berkunjung ke tempat wisata ini saat pergi berlibur ke Solo.Daerah Keraton Surakarta Hadiningrat ini dibagi menjadi Alun-alun Lor, Alun-alun Kidul, Sasana Sumewa, Siti Hinggil Lord an Kidul, Kemandungan Lord an Kidul, Sri Manganti Lord an Kidul, Kedaton, serta Kamagangan.Ada lokasi di keraton juga digunakan sebagai museum.Museum ini menampilkan benda-benda koleksi peninggalan kerajaan. Cocok untuk wisata edukasi budaya Si Kecil. ",
                "Jl. Kamandungan, Baluwarti, Kec. Ps. Kliwon, Kota Surakarta, Jawa Tengah 57144",
                R.drawable.keraton
            ),
            wisata(
                "Taman Balekambang",
                "Bosan dengan wisata Solo yang itu-itu saja? Yuk coba menikmati nuansa alam di taman Balekambang.Taman Balekambang ini merupakan taman milik publik yang terletak di Jalan Balekambang Nomor 1 Surakarta.Menariknya, ini telah ada sejak tahun 1921, lho. Ini merupakan taman bersejarah yang di bangun langsung oleh Mangkunegoro VII ratusan tahun lalu.Nuansa taman yang asri dan rimbun pepohonan tak heran jika banyak pengunjung berpiknik di tempat ini.Sejuk, nyaman dan ada danau yang bisa dinikmati dengan naik kapal kayu.Tak hanya pepohonan, terdapat beberapa spot foto di wisata Solo ini yang bisa dijadikan untuk konten sosial media.Cocok untuk hiburan Si Kecil karena ada beberapa hewan ternak seperti rusa, ayam hias, angsa, dan lain-lain.Tempat ini dibuka sejak pukul 6 pagi sampai 5 sore saja, ya! ",
                "Jl. Balekambang, Manahan, Kec. Banjarsari, Kota Surakarta, Jawa Tengah 57139",
                R.drawable.balekambang
            ),

            wisata(
                "Pabrik Gula De Tjolomadoe",
                "Sekilas tampak seperti di luar negeri, tapi ini termasuk dalam wisata Solo dan Surakarta, lho!Ini merupakan pabrik gula yang bernama De Tjolomadoe yang berlokasi di Jl Adi Sucipto No.1, Paulan Wetan, Malangjiwan, Kec. Colomadu, Kabupaten Karanganyar, Jawa Tengah.Bangunan yang berdiri sejak tahun 1861 ini mulai berhenti operasi sekitar dua puluh tahun silam.Meski begitu, ini dimanfaatkan sebagai tempat wisata Solo dan tempat bersejarah pabrik gula.Desain bangunan menyerupai gaya Eropa dan menjadi daya tarik wisatawan.Di dalamnya Moms bisa melihat berbagai arsip pabrik, mesin tebu raksasa, kafe, dan sebagainya. ",
                "Jl. Adi Sucipto No.1, Paulan Wetan, Malangjiwan, Kec. Colomadu, Kabupaten Karanganyar, Jawa Tengah 57177",
                R.drawable.tjolomadoe
            ),

            wisata(
                "Pasar Gede",
                "Pasar yang biasa disebut sebagai Pasar Gede Harjonagoro ini merupakan pasar tertua yang terdapat di Kota Surakarta.Lokasinya cukup strategis yakni sekitar Kantor Balaikota Solo dan Keraton Kasunanan Surakarta.Bentuk desain bangunannya cukup unik yakni perpaduan arsitektur Belanda dan Jawa.Tak heran jika menjadi spot foto wisatawan di tempat ini ",
                "Jl. Jend. Urip Sumoharjo, Sudiroprajan, Kec. Jebres, Kota Surakarta, Jawa Tengah 57129",
                R.drawable.pasar_gede
            ),

            wisata(
                "Benteng Vastenburg",
                "Jika kalian suka mengumpulkan foto-foto bergaya old school, tak ada salahnya mengunjungi Benteng Vastenburg untuk mengambil foto di bangunan yang bergaya vintage ini.Wisata Solo ini bisa dimasukkan dalam daftar rekomendasi tempat wisata sejarah yang klasik.Karena pohon-pohon yang rimbun di sekitar benteng yang dibangun sejak tahun 1745 ini juga bisa memberikan kesan asri.Berfoto sambil belajar sejarah bangsa Indonesia, menarik bukan?Lokasi Benteng Vastenburg ini terletak di Kedung Lumbu, Kec. Ps. Kliwon, Kota Surakarta, Jawa Tengah 57133. ",
                "Kedung Lumbu, Kec. Ps. Kliwon, Kota Surakarta, Jawa Tengah 57133",
                R.drawable.vastenburg
            ),

            wisata(
                "Serabi Notosuman Solo",
                "Tak lengkap jika berkunjung ke Solo dan Surakarta tak mencicipi makanan legendaris satu ini.Salah satu jajanan tradisional yang wajib dicoba di Solo adalah Serabi Notosuman.Pancake khas Indonesia ini terbuat dari tepung beras dengan santan.Terkadang disajikan dengan kelapa parut dan dibungkus dengan daun kelapa.Serabi Notosuman pembuatannya cukup unik yakni dipanggang dengan arang.Topping yang dipilih biasanya seperti cokelat dan keju.Biasanya pengunjung perlu antre untuk mencicipi wisata kuliner Solo satu ini. Pastikan kalian datang lebih awal, ya! ",
                "Jalan Moh. Yamin Nomor 28, Jayengan, Serengan, Kota Surakarta",
                R.drawable.srabi_notosuman
            ),

            wisata(
                "Grojogan Sewu",
                "Salah satu wisata Solo yang ramai dikunjungi wisatawan adalah Grojongan Sewu.Ini merupakan pemandangan alam air terjun yang menyegarkan.Dikelilingi oleh tebing yang hijau, tempat ini sangat cocok untuk Moms kunjungi saat waktu liburan nanti.Lokasinya tak jauh dari pusat kota Solo, yakni di Jl. Raya Tawangmangu, Beji, Tawangmangu, Kab. Karanganyar, Jawa Tengah.Rute menuju Grojongan Sewu cukup mudah diakses dengan mobil ataupun motor.Hanya dengan Rp18.000 ribu bisa menikmati wisata Solo ini dengan mata telanjang. ",
                "Jl. Raya Tawangmangu, Beji, Kec. Tawangmangu, Kabupaten Karanganyar, Jawa Tengah 57792",
                R.drawable.grojogan_sewu
            ),

            wisata(
                "Candi Cetho Karanganyar",
                "Hanya butuh waktu satu jam berkendara dari Kota Solo, kamu sudah bisa sampai di gerbang indah menuju langit ke tujuh. Tidak percaya?\n" +
                        "               Sekilas, gapura ini mirip dengan Pura Lempuyangan yang berada di Pulau Dewata. Namun nyatanya, ini adalah gapura Candi Ceto yang lokasinya berada di Tawangmangu.\n" +
                        "               Banyak turis berfoto di gapura ini dengan latar belakang berhiaskan langit biru dengan awan putih. Jadi, enggak salah kan kalau gapura ini disebut gerbang menuju langit ke tujuh? Tapi kalau kamu ingin mendapatkan foto yang lebih eksotis, coba saja datang saat senja menjelang. Warna langit yang dihiasi semburat warna jingga dari mentari yang tenggelam akan menambah kesan magis pada foto kamu.",
                "Ceto, RT.01/RW.03, Cetho, Gumeng, Kec. Jenawi, Kabupaten Karanganyar, Jawa Tengah 57792",
                R.drawable.candi_cetho
            ),

            wisata(
                "Tumurun Museum",
                "Museum yang satu ini jadi incaran para pecinta seni yang berkunjung ke Solo. Kata “tumurun” sendiri berarti “turun-temurun”, karena museum pribadi ini didirikan oleh Iwan Kurniawan Lukminto sebagai wujud penghormatan kepada mendiang sang ayah yang adalah kolektor karya seni.\n" +
                        "               Karena semua koleksi yang ada di sini milik pribadi, maka setiap pengunjung yang hendak masuk harus sebelumnya diberi arahan oleh petugas.  Ada dua lantai yang bisa kamu eksplor di sini, masing-masing terbagi dalam koleksi karya seni kontemporer dan modern. Nggak kalah deh sama museum yang ada di New York atau Paris.",
                "Jl. Kebangkitan Nasional No.2, RW.4, Sriwedari, Kec. Laweyan, Kota Surakarta, Jawa Tengah 57141",
                R.drawable.tumurun_museum
            )
        )

        //adapter dari recycle view
        val adapter = ListWisataAdapter(wisatalist){
            Intent(this,DetailWisata::class.java).apply {
                putExtra(INTENT_PARCELABLE,it)
                startActivity(this)

            }
        }

        rvWisata?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvWisata?.adapter = adapter
    }



     override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.buttonPanel_about -> {
                val intent = Intent (this@MainActivity,About::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }


}