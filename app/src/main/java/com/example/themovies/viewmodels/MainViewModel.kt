package com.example.themovies.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themovies.models.TranslateModel
import com.example.themovies.repositories.MainRepository
import com.example.themovies.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _translateList = MutableLiveData<DataState<List<TranslateModel>?>>()
    val translateList: LiveData<DataState<List<TranslateModel>?>> get() = _translateList

    fun getTranslateList() {
        viewModelScope.launch {
            repository.getMyData().onEach { dataState ->
                _translateList.value = dataState
            }.launchIn(viewModelScope)
        }
    }
}