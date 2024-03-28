package com.example.flowexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.flowexample.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: Flowview by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enable edge to edge functionality
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.increase.setOnClickListener {
            // Launch a coroutine in lifecycle scope
            lifecycleScope.launch {
                // Collect the flow
                viewModel.startCounter.collect { counter ->
                    // Show the counter value in text view
                    binding.text.text = counter.absoluteValue.toString()
                }
            }
        }
    }
}

