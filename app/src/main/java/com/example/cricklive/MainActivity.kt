package com.example.cricklive

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cricklive.Adapter.CricketAdapter
import com.example.cricklive.Api.RetrofitInstance
import com.example.cricklive.Model.CricketData
import com.example.cricklive.Model.Data
import com.example.cricklive.databinding.ActivityMainBinding
import com.example.cricklive.databinding.ItemLayoutBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    lateinit var adapter: CricketAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show()
        RetrofitInstance.api.getLiveScore("9055b29a-2850-4dae-9f5d-afc7d37599c0").enqueue(object : Callback<CricketData?> {
            override fun onResponse(call: Call<CricketData?>, response: Response<CricketData?>) {


                if(response.isSuccessful){
                    adapter=CricketAdapter(response.body()!!.data as ArrayList<Data>)
                    binding.recycleView.adapter=adapter
                }
            }

            override fun onFailure(call: Call<CricketData?>, t: Throwable) {

            }
        })
    }
}