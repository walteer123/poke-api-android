package br.com.wab.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import br.com.wab.myapplication.repository.handler.ExceptionHandler
import br.com.wab.myapplication.service.BerryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay

class BerryDetailsViewModel: ViewModel() {

    private val service = BerryService()

    private val job = Job()


    fun getBerry(
        id : Int,
        onStarted: () -> Unit = {}
    ) = liveData(job + Dispatchers.IO + ExceptionHandler.defaultHandler) {
        onStarted()
        val response  = service.getBerry(id)
        delay(5000)
        emit(response)
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}