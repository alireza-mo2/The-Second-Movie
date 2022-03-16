package com.example.themovies.network

import com.example.themovies.models.TranslateModel
import retrofit2.Response
import retrofit2.http.GET


interface DataService {

    @GET("translate_list.php")
    suspend fun getTranslateList(): Response<List<TranslateModel>>


}