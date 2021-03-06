package com.hangular.hangular.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hangular.hangular.ui.baca.CaraBacaActivity
import com.hangular.hangular.ui.baca.CaraBacaViewModel
import com.hangular.hangular.ui.detail.DetailViewModel
import com.hangular.hangular.ui.home.MainViewModel
import com.hangular.hangular.ui.hangul.VocalViewModel
import com.hangular.hangular.ui.quiz.QuizViewModel

class ViewModelFactory private constructor(private val application: Application) : ViewModelProvider.NewInstanceFactory()
{
    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null
        @JvmStatic
        fun getInstance(application: Application): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(application)
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VocalViewModel::class.java)) {
            return VocalViewModel(application) as T
        }
        else if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application) as T
        }
        else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(application) as T
        }
        else if (modelClass.isAssignableFrom(CaraBacaViewModel::class.java)) {
            return CaraBacaViewModel(application) as T
        }
        else if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
            return QuizViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}