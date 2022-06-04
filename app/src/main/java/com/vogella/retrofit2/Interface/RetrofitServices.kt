package com.vogella.retrofit2.Interface

import com.vogella.retrofit2.Model.Movie
import retrofit2.Call
import retrofit2.http.*


interface RetrofitServices {

    @GET("marvel")
    fun getMovieList() : Call<MutableList<Movie>>
}