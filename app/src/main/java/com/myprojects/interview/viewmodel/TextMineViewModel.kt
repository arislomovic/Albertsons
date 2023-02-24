package com.myprojects.interview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myprojects.interview.model.TextMineResponse
import com.myprojects.interview.repository.TextMineRepository
import kotlinx.coroutines.launch

class TextMineViewModel(private val repository: TextMineRepository) : ViewModel() {

    private val _textMineLiveData = MutableLiveData<List<String>>()
    val textMineLiveData: LiveData<List<String>> = _textMineLiveData

    fun getLongFormFromAbbreviation(abbreviation: String) {
        viewModelScope.launch {
            val longFormResult = repository.getLongForm(abbreviation)
            val results = longFormResult?.longForms?.map { it.longForm }.orEmpty()
            _textMineLiveData.postValue(results)
        }
    }
}