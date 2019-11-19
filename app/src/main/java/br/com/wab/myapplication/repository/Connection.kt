package br.com.wab.myapplication.repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://pokeapi.co/api/v2/"

object Connection {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val berryRepository: BerryRepository by lazy {
        retrofit.create(BerryRepository::class.java)
    }

}