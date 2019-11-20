package br.com.wab.myapplication.ui.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import br.com.wab.myapplication.model.GenericResultsResponse
import br.com.wab.myapplication.repository.handler.ExceptionHandler
import br.com.wab.myapplication.service.BerryService
import kotlinx.coroutines.*

class BerryViewModel : ViewModel() {

    private val service = BerryService()

    private val job = Job()

    //val berries = MutableLiveData<MutableList<GenericResultsResponse>>()

    fun berries(
        onStarted:() -> Unit = {},
        onFinished:() -> Unit = {}
    ) = liveData(job + Dispatchers.IO + ExceptionHandler.defaultHandler) {
        onStarted()

        delay(2000)
        val response = service.getBerriesList()
        emit(response.results)

        onFinished()
    }




    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}