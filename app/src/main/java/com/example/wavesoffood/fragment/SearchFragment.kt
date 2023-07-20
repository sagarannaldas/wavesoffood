package com.example.wavesoffood.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.MenuAdapter
import com.example.wavesoffood.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var menuAdapter: MenuAdapter

    private val foodNames = listOf<String>(
        "Burger",
        "Sandwich",
        "Momo",
        "Frankie",
        "Burger",
        "Sandwich",
        "Momo",
        "Frankie"
    )
    private val priceList = listOf<String>("$10", "$5", "$8", "$4", "$10", "$5", "$8", "$4")
    private val foodImages = listOf<Int>(
        R.drawable.ic_menu1,
        R.drawable.ic_menu2,
        R.drawable.ic_menu3,
        R.drawable.ic_menu2,
        R.drawable.ic_menu1,
        R.drawable.ic_menu2,
        R.drawable.ic_menu3,
        R.drawable.ic_menu2
    )

    private val filteredFoodNames = mutableListOf<String>()
    private val filteredPriceList = mutableListOf<String>()
    private val filteredFoodImages = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        menuAdapter = MenuAdapter(
            ArrayList(filteredFoodNames),
            ArrayList(filteredPriceList),
            ArrayList(filteredFoodImages)
        )

        binding.rvSearch.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSearch.adapter = menuAdapter
        setUpSearchView()
        showAllMenu()
    }

    private fun showAllMenu() {
        filteredFoodNames.clear()
        filteredPriceList.clear()
        filteredFoodImages.clear()

        filteredFoodNames.addAll(foodNames)
        filteredPriceList.addAll(priceList)
        filteredFoodImages.addAll(foodImages)

        menuAdapter.notifyDataSetChanged()
    }

    private fun setUpSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String?) {
        filteredFoodNames.clear()
        filteredPriceList.clear()
        filteredFoodImages.clear()

        foodNames.forEachIndexed { index, foodName ->
            if (query != null) {
                if (foodName.contains(query, ignoreCase = true)) {
                    filteredFoodNames.add(foodName)
                    filteredPriceList.add(priceList[index])
                    filteredFoodImages.add(foodImages[index])
                }
            }
        }
        menuAdapter.notifyDataSetChanged()
    }
}