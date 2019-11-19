package br.com.wab.myapplication.service
import br.com.wab.myapplication.repository.Connection

class BerryService {

    private val repository = Connection.berryRepository

    suspend fun getBerriesList() = repository.getAllBerries()

    suspend fun getBerry(id: Int) = repository.getBerryById(id)


    
}