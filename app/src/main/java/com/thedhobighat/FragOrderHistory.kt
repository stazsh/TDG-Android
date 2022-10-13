package com.thedhobighat

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.HttpException
import java.io.IOException

class FragOrderHistory : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.frag_order_history, container, false)
        val api = RetrofitInstance.getInstance().create(TdgApi::class.java)
        val sharedPreferences: SharedPreferences? =
            activity?.getSharedPreferences("TDG_APP", Context.MODE_PRIVATE)

        lifecycleScope.launchWhenCreated {
            val response = try {
                api.getOrderHistory("Bearer ${sharedPreferences?.getString("jwt", "NULL")}")
            } catch (e: IOException) {
                Toast.makeText(
                    activity,
                    "IOException, you might not have internet connection",
                    Toast.LENGTH_SHORT
                ).show()
                return@launchWhenCreated
            } catch (e: HttpException) {
                Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
                return@launchWhenCreated
            }
            Log.i("hi", "${response.body().toString()} ${response.code()}")

            if (response.body() != null) {
                val adapter = AdapterOrderHistory(response.body()!!.payload, parentFragmentManager)
                val rv = view.findViewById<RecyclerView>(R.id.recycler_view)
                rv.layoutManager = LinearLayoutManager(activity)
                rv.adapter = adapter
            }
        }

        return view
    }
}