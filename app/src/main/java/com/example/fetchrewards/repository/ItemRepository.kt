package com.example.fetchrewards.repository

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.util.Log.d
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fetchrewards.service.FetchClient
import com.example.fetchrewards.model.InformationItems
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemRepository {

    fun getItemData(context: Context): LiveData<List<Pair<Int, List<InformationItems>>>> {
        val data = MutableLiveData<List<Pair<Int, List<InformationItems>>>>()

        FetchClient().api.getInformation().enqueue(object : Callback<List<InformationItems>?> {
            override fun onResponse(
                call: Call<List<InformationItems>?>,
                response: Response<List<InformationItems>?>
            ) {

                // If the API call is successful, process the data and update the LiveData object.
                // Regarding sorting: Since the name field is a string, sorting it directly will not make sense because it will show 28>276
// I addressed this by separating the name and converting the second element to an integer before applying the sorting logic.


            if (response.isSuccessful) {
                    val responseBody = response.body()
                    val items = responseBody
                        ?.filter { !it.name.isNullOrEmpty() }
                        ?.sortedWith(compareBy({ it.listId }, { it.name!!.split(" ")[1].toInt() }))
                        ?.groupBy { it.listId }
                        ?.toList()
                    data.value = items as List<Pair<Int, List<InformationItems>>>?
                }else{
                    Toast.makeText(context, "Failed to fetch data: Response is not successful", Toast.LENGTH_SHORT).show()

                }
            }

            override fun onFailure(call: Call<List<InformationItems>?>, t : Throwable) {
                // If the API call fails, log an error message.
                Toast.makeText(context, "Failed to fetch data: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

        // Return the LiveData object.
        return data
    }
}