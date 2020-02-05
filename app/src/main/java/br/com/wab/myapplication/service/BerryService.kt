package br.com.wab.myapplication.service
import br.com.wab.myapplication.repository.Connection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BerryService {

    private val repository = Connection.berryRepository

    suspend fun getBerriesList() = withContext(Dispatchers.IO){
        repository.getAllBerries()
    }

    suspend fun getBerry(id: Int) = repository.getBerryById(id)

}