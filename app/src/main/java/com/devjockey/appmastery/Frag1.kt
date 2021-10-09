package com.devjockey.appmastery

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.fragment_frag1.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.properties.Delegates


class Frag1 : Fragment() {

    private lateinit var catLogId: String

    //Test
    var imageResponsesList: List<ResultImage> = ArrayList()
    lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val layoutManager = GridLayoutManager(context, 2);
        recycler_view.layoutManager = layoutManager

        //Testing
        catLogId = "5d52cd3f8c31223a0ea27d98"
        fragmentTransition()
    }

    //fragment transition
    private fun fragmentTransition() {
        val value = checkCatLogId()
        if (value == 1) {

            getData()

        } else if (value == 2) {
            //code to be implemented
            Toast.makeText(context, "frag2", Toast.LENGTH_SHORT).show()
        } else if (value == 3) {
            //code to be implemented
            Toast.makeText(context, "frag3", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "An error has occurred", Toast.LENGTH_SHORT).show()
        }
    }


    //getData
    private fun getData() {

        //test id
        val id = 213123;

        //Testing
        //     val call = ApiClientLogin.getLoginService().getImage(2131)
        call.enqueue(object : Callback<List<ResultImage?>?> {
            override fun onResponse(
                call: Call<List<ResultImage?>?>,
                response: Response<List<ResultImage?>?>,
            ) {
                if (response.isSuccessful) {

                    val resultImage: List<ResultImage?>? = response.body();
                    Log.e("context", "resposne" + resultImage.getImageresponse.getUrl())

                } else {
                    Log.e("context", "Server Down");
                }
            }

            override fun onFailure(call: Call<List<ResultImage?>?>, t: Throwable) {
                Log.e("context", "connect to internet");
            }
        })


    }

    //loginId check

    private fun checkCatLogId(): Int {

        return when (catLogId) {
            "5d52cd3f8c31223a0ea27d98" -> {

                1;

            }
            "5d52df458c31223a0ea27dbb" -> {
                2;

            }
            else -> {
                3
            }
        }
    }


}