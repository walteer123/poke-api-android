package br.com.wab.myapplication.repository

import br.com.wab.myapplication.model.Berry
import br.com.wab.myapplication.model.GenericResponse

import retrofit2.http.GET
import retrofit2.http.Path

interface BerryRepository {

    @GET("berry")
    suspend fun getAllBerries(): GenericResponse

    @GET("berry/{id}")
    suspend fun getBerryById(@Path("id") id:Int?): Berry

}