package com.loca.estate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.view.View
import android.widget.Toast
import com.loca.estate.Config.Constants
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.loca.estate.DataLayer.RetrofitService
import com.loca.estate.DataLayer.APICall
import com.loca.estate.Model.PostReturn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val request = RetrofitService.buildService(APICall::class.java)
        val call = request.getPost()
        call.enqueue(object : Callback<PostReturn> {
            override fun onResponse(call: Call<PostReturn>, response: Response<PostReturn>) {
                println("This is the text to show it's done")
                if (response.isSuccessful){
                    println(response.body())
                }
            }
            override fun onFailure(call: Call<PostReturn>, t: Throwable) {
                println("This is the text to show it's failed")
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

    }
}
