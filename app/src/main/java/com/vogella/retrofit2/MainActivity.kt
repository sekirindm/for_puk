package com.vogella.retrofit2

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.vogella.retrofit2.Adapter.MyMovieAdapter
import com.vogella.retrofit2.Common.Common
import com.vogella.retrofit2.Interface.RetrofitServices
import com.vogella.retrofit2.Model.Movie
import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitServices
        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager

        getAllMoviesList()
    }

    private fun getAllMoviesList() {
        mService.getMovieList().enqueue(object : Callback<MutableList<Movie>> {
            override fun onResponse(
                call: Call<MutableList<Movie>>,
                response: Response<MutableList<Movie>>
            ) {
                adapter = MyMovieAdapter(baseContext, response.body() as MutableList<Movie>)
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter
            }

            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {

            }

        })
    }
}
