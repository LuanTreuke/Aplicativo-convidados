package com.example.convidados.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.convidados.model.GuestModel
import com.example.convidados.repository.GuestRepository

class GuestsViewModel(application: Application) : AndroidViewModel(application) {

    //private lateinit var repository: GuestRepository
    private val repository = GuestRepository.getInstance(application.applicationContext)


    private val listAllGuests = MutableLiveData<List<GuestModel>>()
    val guests: LiveData<List<GuestModel>> = listAllGuests

    fun getAll() {
        listAllGuests.value = repository.getAll()
    }

    fun getPresent(){
        listAllGuests.value = repository.getPresence()
    }

    fun getAbsent(){
        listAllGuests.value = repository.getAbsent()
    }

    fun delete(id: Int){
        repository.delete(id)
    }

}