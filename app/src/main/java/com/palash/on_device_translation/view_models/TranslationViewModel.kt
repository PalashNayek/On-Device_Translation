package com.palash.on_device_translation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palash.on_device_translation.repositories.TranslationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TranslationViewModel @Inject constructor(
    private val repository: TranslationRepository
) : ViewModel() {

    private val _translatedText = MutableLiveData<String>()
    val translatedText: LiveData<String> get() = _translatedText

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun downloadModelAndTranslate(text: String) {
        viewModelScope.launch {
            try {
                // Download the translation model if needed
                repository.downloadModelIfNeeded()
                // Translate the input text
                val translated = repository.translateText(text)
                _translatedText.postValue(translated)
            } catch (e: Exception) {
                _error.postValue(e.message)
            }
        }
    }
}