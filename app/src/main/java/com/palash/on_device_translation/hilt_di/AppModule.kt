package com.palash.on_device_translation.hilt_di

import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.TranslatorOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideTranslatorOptions(): TranslatorOptions {
        return TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH)
            .setTargetLanguage(TranslateLanguage.BENGALI)
            .build()
    }

    @Provides
    @Singleton
    fun provideTranslator(options: TranslatorOptions): com.google.mlkit.nl.translate.Translator {
        return com.google.mlkit.nl.translate.Translation.getClient(options)
    }

}