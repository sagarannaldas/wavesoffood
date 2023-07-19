package com.example.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.CartItemBinding


class CartAdapter(
    private val cartItems: MutableList<String>,
    private val cartItemsPrices: MutableList<String>,
    private val cartImages: MutableList<Int>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuantities = IntArray(cartImages.size) { 1 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            CartItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                textViewFoodName.text = cartItems[position]
                textViewPrice.text = cartItemsPrices[position]
                imageViewItem.setImageResource(cartImages[position])
                textViewQuantity.text = quantity.toString()

                buttonMinus.setOnClickListener {
                    decreaseQuantity(position)
                    textViewQuantity.text = itemQuantities[position].toString()
                }
                buttonPlus.setOnClickListener {
                    increaseQuantity(position)
                    textViewQuantity.text = itemQuantities[position].toString()
                }
                imageViewDelete.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION) {
                        deleteItem(position)
                    }
                }
            }
        }
    }

    private fun increaseQuantity(position: Int) {
        if (itemQuantities[position] < 10) {
            itemQuantities[position]++

        }
    }

    private fun decreaseQuantity(position: Int) {
        if (itemQuantities[position] > 1) {
            itemQuantities[position]--

        }
    }

    private fun deleteItem(position: Int) {
        cartItems.removeAt(position)
        cartItemsPrices.removeAt(position)
        cartImages.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, cartItems.size)
    }

}