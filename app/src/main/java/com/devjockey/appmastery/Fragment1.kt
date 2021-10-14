package com.devjockey.appmastery

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_1.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private const val ARG_PARAM1 = "param1"



class Fragment1 : Fragment() {
    private lateinit var catLogId: String
    var resultData: List<Thumbnail> = ArrayList()
    lateinit var layoutManager: RecyclerView.LayoutManager


    private var param1: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            Fragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        catLogId = param1.toString()
        Log.e("context", "catlog:$catLogId")
        //Recycler View
        val layoutManager = GridLayoutManager(context, 2);
        recycler_view?.layoutManager = layoutManager
        fragmentTransition()
    }


    //fragment transition
    private fun fragmentTransition() {
        val value = checkCatLogId()
        if (value == 1) {

            getData()

        } else if (value == 2) {

            getData2()

        } else if (value == 3) {

            getData3()

        } else {

            Toast.makeText(context, "Please wait loading data ........", Toast.LENGTH_SHORT).show()

        }
    }

    private fun getData3() {

        val call = ApiClientLogin.getLoginService().image3
        call.enqueue(object : Callback<ResultImage?> {
            override fun onResponse(call: Call<ResultImage?>, response: Response<ResultImage?>) {

                if (response.isSuccessful) {

                    Log.e("context", "success");
                    Log.e("MainActivity",
                        "Success = " + response.body()!!.get_embedded().getItems())
                    resultData = response.body()!!.get_embedded().getItems()

                    val adapterRecycler = RecyclerAdapter(context, resultData)
                    recycler_view?.adapter = adapterRecycler

                } else {
                    Log.e("context", "Server Down");
                }
            }

            override fun onFailure(call: Call<ResultImage?>, t: Throwable) {
                Log.e("context", "Error");

            }
        })


    }

    private fun getData2() {

        val call = ApiClientLogin.getLoginService().image2
        call.enqueue(object : Callback<ResultImage?> {
            override fun onResponse(call: Call<ResultImage?>, response: Response<ResultImage?>) {

                if (response.isSuccessful) {
                    Log.e("context", "success");
                    Log.e("MainActivity",
                        "Success = " + response.body()!!.get_embedded().getItems())
                    resultData = response.body()!!.get_embedded().getItems()

                    val adapterRecycler = RecyclerAdapter(context, resultData)
                    recycler_view?.adapter = adapterRecycler;
                } else {
                    Log.e("context", "Server Down");
                }
            }

            override fun onFailure(call: Call<ResultImage?>, t: Throwable) {
                Log.e("context", "Error");

            }
        })


    }


    //getData
    private fun getData() {

        val call = ApiClientLogin.getLoginService().image
        call.enqueue(object : Callback<ResultImage?> {
            override fun onResponse(call: Call<ResultImage?>, response: Response<ResultImage?>) {

                if (response.isSuccessful) {
                    Log.e("context", "success");
                    Log.e("MainActivity",
                        "Success = " + response.body()!!.get_embedded().getItems())
                    resultData = response.body()!!.get_embedded().getItems()

                    val adapterRecycler = RecyclerAdapter(context, resultData)
                    recycler_view?.adapter = adapterRecycler;
                } else {
                    Log.e("context", "Server Down")
                }
            }

            override fun onFailure(call: Call<ResultImage?>, t: Throwable) {

                Log.e("context", "Error")

            }
        })


    }

    //loginId check

    private fun checkCatLogId(): Int {

        return when (catLogId) {
            "5d52df0a8c31223a0ea27db1" -> {

                1;

            }
            "5d52df458c31223a0ea27dbb" -> {
                2;

            }
            "5d52f12c8c31223a0ea27e29" -> {
                3;

            }
            else -> {
                4
            }
        }
    }

}