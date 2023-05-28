package com.keltiga.eccomerce.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.keltiga.eccomerce.model.ResponseNewsUpdateItem
import com.keltiga.eccomerce.network.RestfulApi
import com.keltiga.eccomerce.network.RetrofitClient
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (private var api: RestfulApi) : ViewModel() {

        var liveData = MutableLiveData<List<ResponseNewsUpdateItem>?>()

         fun callApi() {
            api.getNewsSliderItems().enqueue(object : Callback<List<ResponseNewsUpdateItem>>{
                override fun onResponse(
                    call: Call<List<ResponseNewsUpdateItem>>,
                    response: Response<List<ResponseNewsUpdateItem>>) {
                    if (response.isSuccessful) {
                        liveData.postValue(response.body())
                        println("Response body: ${response.body()}")
                    } else {
                        liveData.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseNewsUpdateItem>> , t: Throwable) {
                    liveData.postValue(null)
                    println("Error: ${t.message}")
                }
            })
        }

    }



