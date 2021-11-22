package com.asr.sedaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endPoint }
    private lateinit var jenisAdapter: JenisAdapter
    private lateinit var listJenis: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupList()
    }

    override fun onStart() {
        super.onStart()
        getJenis()
    }

    private fun setupList(){
        listJenis = findViewById(R.id.list_data)
        jenisAdapter = JenisAdapter(arrayListOf())
        listJenis.adapter = jenisAdapter
    }

    private fun getJenis(){
        api.data().enqueue(object : Callback<JenisModel>{
            override fun onResponse(call: Call<JenisModel>, response: Response<JenisModel>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.jenis
                    jenisAdapter.setData(listData)
//                    listData.forEach{
//                        Log.e("MainActivity", "jenis ${it.jenis}")
//                    }
                }
            }

            override fun onFailure(call: Call<JenisModel>, t: Throwable) {
                Log.e("MainActivity", t.toString())
            }

        })
    }
}