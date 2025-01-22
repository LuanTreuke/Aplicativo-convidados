package com.example.convidados.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PresentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Todos os presentes"
    }
    val text: LiveData<String> = _text
}