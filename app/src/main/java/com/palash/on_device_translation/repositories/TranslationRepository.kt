package com.palash.on_device_translation.repositories

import com.google.mlkit.nl.translate.Translator
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class TranslationRepository @Inject constructor(
    private val translator: Translator
) {

    suspend fun downloadModelIfNeeded() {
        translator.downloadModelIfNeeded().await()
    }

    suspend fun translateText(text: String): String {
        return translator.translate(text).await()
    }
}