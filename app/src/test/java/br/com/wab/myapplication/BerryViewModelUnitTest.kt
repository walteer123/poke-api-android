package br.com.wab.myapplication

import androidx.lifecycle.LiveData
import br.com.wab.myapplication.model.GenericResponse
import br.com.wab.myapplication.model.GenericResultsResponse
import br.com.wab.myapplication.service.BerryService
import br.com.wab.myapplication.ui.viewmodel.BerryViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class BerryViewModelUnitTest {

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }

   @Test
   fun sum(){

       Assert.assertEquals(2,1+1)

   }




}