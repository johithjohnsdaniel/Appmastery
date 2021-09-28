package com.devjockey.appmastery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_frag1.*
import kotlinx.android.synthetic.main.fragment_frag2.*
import kotlinx.android.synthetic.main.fragment_frag3.*
import org.json.JSONException


class Frag3 : Fragment() {

    lateinit var dataMembers: ArrayList<DataMembers>
    lateinit var myAdapter: RecyclerAdapter
    lateinit var mRequestQueue: RequestQueue
    lateinit var layoutManager: RecyclerView.LayoutManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag3, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Layout Manager
        layoutManager= GridLayoutManager(context,2);
        recycler_view_frag3.layoutManager=layoutManager
        dataMembers= ArrayList();
        mRequestQueue= Volley.newRequestQueue(context)

        //Json parse
        jsonParse()


    }

    //Json Parse

    private fun jsonParse() {


        val url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true"
        val request = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                try {
                    //obj array
                    val jsonArray = response.getJSONArray("hits")
                    for (i in 0 until jsonArray.length()) {
                        val hit = jsonArray.getJSONObject(i)
                        val imageUrl = hit.getString("webformatURL")
                        dataMembers.add(DataMembers(imageUrl))
                    }
                    myAdapter= RecyclerAdapter(context, dataMembers)
                    recycler_view_frag3.adapter=myAdapter
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }) { error -> error.printStackTrace() }
        mRequestQueue.add(request)
    }


}