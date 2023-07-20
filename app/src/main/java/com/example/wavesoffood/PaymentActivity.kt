package com.example.wavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wavesoffood.databinding.ActivityPaymentBinding
import com.example.wavesoffood.fragment.CongratsBottomSheetFragment

class PaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPlaceOrder.setOnClickListener {
            val congratsBottomSheet = CongratsBottomSheetFragment()
            congratsBottomSheet.show(supportFragmentManager, "test")
        }

        binding.imageButtonBack.setOnClickListener {
            onBackPressed()
        }
    }
}