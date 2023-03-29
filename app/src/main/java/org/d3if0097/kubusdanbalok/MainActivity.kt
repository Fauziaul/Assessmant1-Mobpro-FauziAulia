package org.d3if0097.kubusdanbalok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import org.d3if0097.kubusdanbalok.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener { hitung() }
    }
    private fun hitung() {
        Log.d("MainActivity", "Tombol diklik!")

        val panjang = binding.txtPanjang.text.toString()
        if (TextUtils.isEmpty(panjang)) {
            Toast.makeText(this, R.string.panjang_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val tinggi = binding.txtTinggi.text.toString()
        if (TextUtils.isEmpty(tinggi)) {
            Toast.makeText(this, R.string.tinggi_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val lebar = binding.txLebar.text.toString()
        if (TextUtils.isEmpty(lebar)) {
            Toast.makeText(this, R.string.lebar_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val volume = panjang.toDouble() * lebar.toDouble() * tinggi.toDouble()
        val luas = 2 * ((panjang.toDouble()*lebar.toDouble()) + (panjang.toDouble()*tinggi.toDouble()) + (lebar.toDouble()*tinggi.toDouble()))
        binding.luasPermungkaan.text = getString(R.string.luas_x, luas)
        binding.volume.text = getString(R.string.volume, volume)

    }
    
}
