package com.example.fetchrewards.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.fetchrewards.model.InformationItems

class ItemViewModel : ViewModel() {

    private val repository : ItemRepository= ItemRepository()
    fun getItemData(context : Context) : LiveData<List<Pair<Int, List<InformationItems>>>> {
        return repository.getItemData(context)
    }

}