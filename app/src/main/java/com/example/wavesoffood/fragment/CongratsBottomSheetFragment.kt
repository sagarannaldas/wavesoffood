package com.example.wavesoffood.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wavesoffood.MainActivity
import com.example.wavesoffood.R
import com.example.wavesoffood.databinding.FragmentCongratsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CongratsBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentCongratsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCongratsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonGoHome.setOnClickListener {
            startActivity(Intent(requireContext(),MainActivity::class.java))
        }
    }

}