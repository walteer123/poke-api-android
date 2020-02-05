package br.com.wab.myapplication

import org.junit.Assert
import org.junit.Before
import org.junit.Test
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