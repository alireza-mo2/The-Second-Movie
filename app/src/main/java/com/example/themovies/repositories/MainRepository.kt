package com.example.themovies.repositories

import com.example.themovies.models.TranslateModel
import com.example.themovies.network.DataService
import com.example.themovies.utils.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject


class MainRepository
@Inject constructor(
    private val dataService: DataService
) {

    fun getMyData(): Flow<DataState<List<TranslateModel>?>> = callbackFlow {
        send(DataState.Loading)
        withContext(Dispatchers.IO) {
            val response = dataService.getTranslateList()
            delay(1000)
            if (response.isSuccessful)
                send(DataState.Success(response.body()))
            else
                send(DataState.Error(response.message()))
        }

        awaitClose {

        }
    }
}