package com.example.wavesoffood.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.MenuAdapter
import com.example.wavesoffood.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val menuFoodNames = listOf<String>(
            "Burger",
            "Sandwich",
            "Momo",
            "Frankie",
            "Burger",
            "Sandwich",
            "Momo",
            "Frankie"
        )
        val menuPriceList = listOf<String>("$10", "$5", "$8", "$4", "$10", "$5", "$8", "$4")
        val menuFoodImages = listOf<Int>(
            R.drawable.ic_menu1,
            R.drawable.ic_menu2,
            R.drawable.ic_menu3,
            R.drawable.ic_menu2,
            R.drawable.ic_menu1,
            R.drawable.ic_menu2,
            R.drawable.ic_menu3,
            R.drawable.ic_menu2
        )

        val adapter = MenuAdapter(
            ArrayList(menuFoodNames),
            ArrayList(menuPriceList),
            ArrayList(menuFoodImages)
        )
        binding.rvMenu.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMenu.adapter = adapter

        binding.ivBack.setOnClickListener {
            dismiss()
        }

    }
}