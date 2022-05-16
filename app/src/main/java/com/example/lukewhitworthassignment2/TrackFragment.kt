package com.example.lukewhitworthassignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.lukewhitworthassignment2.api.ApiService
import com.example.lukewhitworthassignment2.model.TrackResponse
import com.example.lukewhitworthassignment2.view.UserAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrackFragment(index: Int) : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: UserAdapter
    private val tabIndex = index

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rock, container, false)
        recyclerView = view.findViewById(R.id.rv_track_list)

        startRetrofit()
        return view
    }

    private fun startRetrofit() {
        when (tabIndex) {
            // Rock
            0 -> {
                ApiService.createRetrofit().create(ApiService::class.java).getRock()
                    .enqueue(object : Callback<TrackResponse> {
                        override fun onResponse(
                            call: Call<TrackResponse>,
                            response: Response<TrackResponse>
                        ) {
                            if (response.isSuccessful) {
                                adapter = UserAdapter(response.body()!!.results)
                                recyclerView.adapter = adapter
                            }
                        }

                        override fun onFailure(call: Call<TrackResponse>, t: Throwable) {
                            Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
                        }
                    })
            }
            // Classic
            1 -> {
                ApiService.createRetrofit().create(ApiService::class.java).getClassic()
                    .enqueue(object : Callback<TrackResponse> {
                        override fun onResponse(
                            call: Call<TrackResponse>,
                            response: Response<TrackResponse>
                        ) {
                            if (response.isSuccessful) {
                                adapter = UserAdapter(response.body()!!.results)
                                recyclerView.adapter = adapter
                            }
                        }

                        override fun onFailure(call: Call<TrackResponse>, t: Throwable) {
                            Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
                        }
                    })
            }
            // Pop
            else -> {
                ApiService.createRetrofit().create(ApiService::class.java).getPop()
                    .enqueue(object : Callback<TrackResponse> {
                        override fun onResponse(
                            call: Call<TrackResponse>,
                            response: Response<TrackResponse>
                        ) {
                            if (response.isSuccessful) {
                                adapter = UserAdapter(response.body()!!.results)
                                recyclerView.adapter = adapter
                            }
                        }

                        override fun onFailure(call: Call<TrackResponse>, t: Throwable) {
                            Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
                        }
                    })
            }
        }
    }
}