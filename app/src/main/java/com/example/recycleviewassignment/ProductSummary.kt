package com.example.recycleviewassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recycleviewassignment.databinding.ActivityProductSummaryBinding

class ProductSummary : AppCompatActivity() {
    private lateinit var binding: ActivityProductSummaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProductSummaryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.productImage.setImageResource(intent.getIntExtra("product_image",0))
        binding.name.text = intent.getStringExtra("name")
        binding.description.text = intent.getStringExtra("des")
        binding.price.text = intent.getStringExtra("cost")

        binding.back.setOnClickListener{
           finish()
        }
    }
}