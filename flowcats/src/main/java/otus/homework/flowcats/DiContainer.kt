package otus.homework.flowcats

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DiContainer {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://dog-facts-api.herokuapp.com/api/v1/resources/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service by lazy { retrofit.create(CatsService::class.java) }

    val repository by lazy { CatsRepository(service) }
}