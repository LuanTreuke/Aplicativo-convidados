package com.example.convidados.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.convidados.model.GuestModel
import com.example.convidados.model.SuccessFailure
import com.example.convidados.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    private val guestModel = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = guestModel

    private val _saveGuest = MutableLiveData<SuccessFailure>()
    val saveGuest: LiveData<SuccessFailure> = _saveGuest

    fun save(guest: GuestModel){
        val successFailure = SuccessFailure(true, "")
        if(guest.id == 0){
            successFailure.success = repository.insert(guest)
        }else{
            successFailure.success = repository.update(guest)
        }
    }

    fun get(id: Int){
        guestModel.value = repository.get(id)
    }

}