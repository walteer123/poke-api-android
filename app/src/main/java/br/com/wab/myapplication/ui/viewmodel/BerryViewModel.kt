package br.com.wab.myapplication.ui.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import br.com.wab.myapplication.repository.handler.ExceptionHandler
import br.com.wab.myapplication.service.BerryService
import kotlinx.coroutines.*
import javax.inject.Inject

class BerryViewModel @Inject constructor() : ViewModel() {

    private val service = BerryService()

    private val job = Job()

    fun berries() = liveData(job + Dispatchers.Main + ExceptionHandler.defaultHandler) {

        delay(2000)
        val response = service.getBerriesList()
        emit(response.results)

    }


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}