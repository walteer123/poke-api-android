package br.com.wab.myapplication.ui.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import br.com.wab.myapplication.repository.handler.ExceptionHandler
import br.com.wab.myapplication.service.BerryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class BerryViewModel : ViewModel() {

    private val service = BerryService()

    private val job = Job()

    val berries = liveData(job + Dispatchers.IO + ExceptionHandler.defaultHandler) {
        val response = service.getBerriesList()
        emit(response)
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}