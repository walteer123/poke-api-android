package br.com.wab.myapplication.repository.handler

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler

object ExceptionHandler {

    val defaultHandler: CoroutineExceptionHandler  by lazy {
        CoroutineExceptionHandler { _, exception ->
            Log.d("Exceção!", "${exception.message}")
        }
    }

}