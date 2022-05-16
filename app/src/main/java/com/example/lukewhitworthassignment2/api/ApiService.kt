package com.example.lukewhitworthassignment2.api

import com.example.lukewhitworthassignment2.model.TrackResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    // https://itunes.apple.com/search?term=pop&amp;media=music&entity=song&limit=5
    // NOTICE: you need to use &amp; after the term=<query> BUT NOT for other query terms

    @GET("search?term=rock&amp;media=music&entity=song&limit=50")
    fun getRock(
    ): Call<TrackResponse>

    @GET("search?term=classic&amp;media=music&entity=song&limit=50")
    fun getClassic(
    ): Call<TrackResponse>

    @GET("search?term=pop&amp;media=music&entity=song&limit=50")
    fun getPop(
    ): Call<TrackResponse>

    companion object {
        private var instance: Retrofit? = null

        fun createRetrofit(): Retrofit {
            if (instance == null) {
                instance =
                    Retrofit.Builder()
                        .baseUrl("https://itunes.apple.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }

            return instance!! // !! -> this will NOT be null here
        }
    }

}