package com.example.recycleviewassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleviewassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var cartList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater);
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val products = arrayListOf(
            Product("Smartphone", "Latest model ", R.drawable.mobile, R.drawable.apple, "$999"),
            Product("Headphones", "Noise-cancelling ", R.drawable.head_phones, R.drawable.samsung, "$299"),
            Product("Smartwatch", "Fitness tracking ", R.drawable.watch, R.drawable.boat, "$199"),
            Product("Drone", "Compact drone ", R.drawable.drone, R.drawable.apple, "$499"),
            Product("Action Camera", "High-definition ", R.drawable.camera, R.drawable.samsung, "$349"),
            Product("E-Reader", "Advanced e-reader", R.drawable.tablet, R.drawable.samsung, "$129")
        )

        val adaptar = MyAdapter(this,products,cartList)
        binding.rv.adapter = adaptar
        binding.rv.layoutManager = LinearLayoutManager(this)


        binding.viewCart.setOnClickListener{
            runOnUiThread{
                val items = cartList.joinToString(separator = "\n")
                Toast.makeText(this,items,Toast.LENGTH_LONG).show()
            }
        }

    }
}