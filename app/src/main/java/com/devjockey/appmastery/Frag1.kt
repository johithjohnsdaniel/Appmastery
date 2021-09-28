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
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_frag1.*
import org.json.JSONArray
import org.json.JSONException
import com.android.volley.VolleyError

import org.json.JSONObject


class Frag1 : Fragment() {


    lateinit var dataMembers: ArrayList<DataMembers>
    lateinit var myAdapter: RecyclerAdapter
    lateinit var mRequestQueue: RequestQueue
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
        dataMembers = ArrayList();
        mRequestQueue = Volley.newRequestQueue(context)
        jsonParse()


    }

    //Json Parse
    private fun jsonParse() {


        val url =
            "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true"
        val request = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                try {
                    val jsonArray = response.getJSONArray("hits")
                    for (i in 0 until jsonArray.length()) {
                        val hit = jsonArray.getJSONObject(i)
                        val imageUrl = hit.getString("webformatURL")
                        dataMembers.add(DataMembers(imageUrl))
                    }
                    myAdapter = RecyclerAdapter(context, dataMembers)
                    recycler_view.adapter = myAdapter
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }) { error -> error.printStackTrace() }
        mRequestQueue.add(request)
    }


}