package com.palash.on_device_translation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.palash.on_device_translation.R
import com.palash.on_device_translation.databinding.FragmentHomeBinding
import com.palash.on_device_translation.view_models.TranslationViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TranslationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Button click to start translation
        binding.translateButton.setOnClickListener {
            val inputText = binding.inputText.text.toString()
            if (inputText.isNotBlank()) {
                lifecycleScope.launch {
                    viewModel.downloadModelAndTranslate(inputText)
                }
            } else {
                Toast.makeText(requireContext(), "Please enter some text", Toast.LENGTH_SHORT).show()
            }
        }

        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.translatedText.observe(viewLifecycleOwner) { translatedText ->
            binding.resultText.text = "Translated: $translatedText"
        }

        viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            Toast.makeText(requireContext(), "Error: $errorMessage", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}