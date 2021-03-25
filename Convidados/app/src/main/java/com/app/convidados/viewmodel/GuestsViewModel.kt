package com.app.convidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.convidados.service.constants.GuestConstants
import com.app.convidados.service.model.GuestModel
import com.example.convidados.service.repository.GuestRepository

class GuestsViewModel(private val mGuestRepository: GuestRepository) : ViewModel() {

    private val mGuestList = MutableLiveData<List<GuestModel>>()
    val guestList: LiveData<List<GuestModel>> = mGuestList

    fun load(filter: Int) {

        if (filter == GuestConstants.FILTER.EMPTY) {
            mGuestList.value = mGuestRepository.getAll()
        } else if (filter == GuestConstants.FILTER.PRESENT) {
            mGuestList.value = mGuestRepository.getPresent()
        } else {
            mGuestList.value = mGuestRepository.getAbsent()
        }

    }

    fun delete(id: Int) {
        val guest = mGuestRepository.get(id)
        mGuestRepository.delete(guest)
    }
}