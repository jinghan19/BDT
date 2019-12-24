package com.example.bdt

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class BDViewModel (application:Application) : AndroidViewModel(application) {
    private val bdRepository: BDRepository

    val allBDs: LiveData<List<BD>>

    init { //default constructor
        val bdDao = BDDatabase.getInstance(application).bdDao()
        bdRepository = BDRepository(bdDao)
        allBDs = bdRepository.alldb //ask all data in repository to store in allBDs

        /**
         * The implementation of insert() in the database is completely hidden from the UI.
         * Room ensures that you're not doing any long running operations on
         * the main thread, blocking the UI, so we don't need to handle changing Dispatchers.
         * ViewModels have a coroutine scope based on their lifecycle called
         * viewModelScope which we can use here.
         */
        //every mehond use lauch must have suspend, suspend is to run in backgroud
        fun insertBD(bd: BD) = viewModelScope.launch {
            bdRepository.insertBD(bd)
        }
    }
}
