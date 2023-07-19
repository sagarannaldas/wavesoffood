package com.example.wavesoffood.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.CartAdapter
import com.example.wavesoffood.databinding.FragmentCartBinding
import java.util.ArrayList


class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val cartFoodNames = listOf<String>("Burger", "Sandwich", "Momo", "Frankie")
        val cartPriceList = listOf<String>("$10", "$5", "$8", "$4")
        val cartFoodImages = listOf<Int>(
            R.drawable.ic_menu1, R.drawable.ic_menu2, R.drawable.ic_menu3, R.drawable.ic_menu2
        )

        val adapter = CartAdapter(ArrayList(cartFoodNames), ArrayList(cartPriceList), ArrayList(cartFoodImages))
        binding.rvCart.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCart.adapter = adapter

    }
}