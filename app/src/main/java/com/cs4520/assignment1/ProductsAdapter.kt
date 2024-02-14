package com.cs4520.assignment1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(private val products: List<List<Any?>>) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productName: TextView = view.findViewById(R.id.product_name)
        val productExpiryDate: TextView = view.findViewById(R.id.product_expiry_date)
        val productPrice: TextView = view.findViewById(R.id.product_price)
        val productImage: ImageView = view.findViewById(R.id.product_image)
        val productItemLayout: ConstraintLayout = view.findViewById(R.id.product_item_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.productName.text = product[0] as? String ?: "" // Name
        holder.productPrice.text = "Price: ${product[3]}" // Price
        holder.productExpiryDate.visibility = if ((product[2] as? String).isNullOrBlank()) View.GONE else View.VISIBLE
        holder.productExpiryDate.text = "Expires on: ${product[2]}" // Expiry Date
        val backgroundColor = if (product[1] == "Equipment") "#E06666" else "#FFD965" // Type
        holder.productItemLayout.setBackgroundColor(Color.parseColor(backgroundColor))
        val imageResource = if (product[1] == "Equipment") R.drawable.equipment else R.drawable.food
        holder.productImage.setImageResource(imageResource)
    }

    override fun getItemCount(): Int = products.size
}
