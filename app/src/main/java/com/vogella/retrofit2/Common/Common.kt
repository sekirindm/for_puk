package com.vogella.retrofit2.Common

import com.vogella.retrofit2.Interface.RetrofitServices
import com.vogella.retrofit2.Model.RetrofitClient

object Common {
    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val retrofitServices : RetrofitServices
        get()= RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)

}