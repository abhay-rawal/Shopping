package com.example.recycleviewassignment

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewassignment.databinding.CardLayoutBinding


class MyAdapter(val context : Context,private val blist: ArrayList<Product>,private val cartList:ArrayList<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val book = blist[position]
        holder.binding.productImage.setImageResource(book.image)
        holder.binding.logo.setImageResource(book.logo)
        holder.binding.name.text = book.name
        holder.binding.ProductDescription.text = book.des
        holder.binding.Price.text = book.cost.toString()

        holder.binding.relativeLayout.setOnClickListener{
            val intent = Intent(context,ProductSummary::class.java)
            intent.putExtra("product_image",book.image)
            intent.putExtra("des",book.des)
            intent.putExtra("name",book.name)
            intent.putExtra("cost",book.cost)
            context.startActivity(intent)
        }
        holder.binding.Add.setOnClickListener(){
            cartList.add(book.name)
        }

    }

    override fun getItemCount(): Int {
        return blist.size
    }

    inner class MyViewHolder(val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}


