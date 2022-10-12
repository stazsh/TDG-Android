package com.thedhobighat

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import com.google.gson.Gson

class FragChooseItems : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.frag_choose_items, container, false)

        view.findViewById<Button>(R.id.blazer_up).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.blazer_count)
            var newCount = Integer.parseInt(item.text.toString()) - 1
            if (newCount < 0)
                newCount = 0
            item.text = newCount.toString()
        }
        view.findViewById<Button>(R.id.blazer_down).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.blazer_count)
            val newCount = Integer.parseInt(item.text.toString()) + 1
            item.text = newCount.toString();
        }

        view.findViewById<Button>(R.id.shirt_up).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.shirt_count)
            var newCount = Integer.parseInt(item.text.toString()) - 1
            if (newCount < 0)
                newCount = 0
            item.text = newCount.toString()
        }
        view.findViewById<Button>(R.id.shirt_down).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.shirt_count)
            val newCount = Integer.parseInt(item.text.toString()) + 1
            item.text = newCount.toString()
        }

        view.findViewById<Button>(R.id.pant_up).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.pant_count)
            var newCount = Integer.parseInt(item.text.toString()) - 1
            if (newCount < 0)
                newCount = 0
            item.text = newCount.toString()
        }
        view.findViewById<Button>(R.id.pant_down).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.pant_count)
            val newCount = Integer.parseInt(item.text.toString()) + 1
            item.text = newCount.toString()
        }

        view.findViewById<Button>(R.id.saree_up).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.saree_count)
            var newCount = Integer.parseInt(item.text.toString()) - 1
            if (newCount < 0)
                newCount = 0
            item.text = newCount.toString()
        }
        view.findViewById<Button>(R.id.saree_down).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.saree_count)
            val newCount = Integer.parseInt(item.text.toString()) + 1
            item.text = newCount.toString()
        }

        view.findViewById<Button>(R.id.ladup_up).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.ladup_count)
            var newCount = Integer.parseInt(item.text.toString()) - 1
            if (newCount < 0)
                newCount = 0
            item.text = newCount.toString()
        }
        view.findViewById<Button>(R.id.ladup_down).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.ladup_count)
            val newCount = Integer.parseInt(item.text.toString()) + 1
            item.text = newCount.toString()
        }

        view.findViewById<Button>(R.id.laddown_up).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.laddown_count)
            var newCount = Integer.parseInt(item.text.toString()) - 1
            if (newCount < 0)
                newCount = 0
            item.text = newCount.toString()
        }
        view.findViewById<Button>(R.id.laddown_down).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.laddown_count)
            val newCount = Integer.parseInt(item.text.toString()) + 1
            item.text = newCount.toString()
        }

        view.findViewById<Button>(R.id.others_up).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.others_count)
            var newCount = Integer.parseInt(item.text.toString()) - 1
            if (newCount < 0)
                newCount = 0
            item.text = newCount.toString()
        }
        view.findViewById<Button>(R.id.others_down).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.others_count)
            val newCount = Integer.parseInt(item.text.toString()) + 1
            item.text = newCount.toString()
        }

        val items = Array<TextView>(7) { i -> view.findViewById(intArrayOf(
            R.id.blazer_count,
            R.id.shirt_count,
            R.id.pant_count,
            R.id.saree_count,
            R.id.ladup_count,
            R.id.laddown_count,
            R.id.others_count
        )[i])}

        val serviceableType = arguments?.getString("type")
        view.findViewById<ConstraintLayout>(R.id.add_to_cart_btn).setOnClickListener{
            val sharedPreferences: SharedPreferences? = activity?.getSharedPreferences("TDG_APP", Context.MODE_PRIVATE)
            if (sharedPreferences != null) {
                if (!sharedPreferences.contains("cart"))
                    sharedPreferences.edit().putString("cart", Gson().toJson(CartInstance(
                        listOf(
                            Serviceable("blazer", 0),
                            Serviceable("shirt_and_tshirt", 0),
                            Serviceable("pant_and_trousers", 0),
                            Serviceable("saree", 0),
                            Serviceable("ladies_upper", 0),
                            Serviceable("ladies_lower", 0),
                            Serviceable("cloths_and_others", 0)
                        ), listOf(
                            Serviceable("blazer", 0),
                            Serviceable("shirt_and_tshirt", 0),
                            Serviceable("pant_and_trousers", 0),
                            Serviceable("saree", 0),
                            Serviceable("ladies_upper", 0),
                            Serviceable("ladies_lower", 0),
                            Serviceable("cloths_and_others", 0)
                        ), listOf(
                            Serviceable("blazer", 0),
                            Serviceable("shirt_and_tshirt", 0),
                            Serviceable("pant_and_trousers", 0),
                            Serviceable("saree", 0),
                            Serviceable("ladies_upper", 0),
                            Serviceable("ladies_lower", 0),
                            Serviceable("cloths_and_others", 0)
                        )
                    ))).apply()

                val existingCart: String? = sharedPreferences.getString("cart", null)
                val parsedExistingCart = Gson().fromJson(existingCart, CartInstance::class.java)

                if (serviceableType === "FORMAL_WASH") {
                    for (i in 0..6)
                        parsedExistingCart.formal_wash.elementAt(i).quantity = Integer.parseInt(items[i].text.toString())
                } else if (serviceableType === "DRY_WASH") {
                    for (i in 0..6)
                        parsedExistingCart.dry_wash.elementAt(i).quantity = Integer.parseInt(items[i].text.toString())
                } else if (serviceableType === "STEAM_IRON") {
                    for (i in 0..6)
                        parsedExistingCart.steam_iron.elementAt(i).quantity = Integer.parseInt(items[i].text.toString())
                }

                sharedPreferences.edit().putString("cart", Gson().toJson(parsedExistingCart)).apply()
                Toast.makeText(activity, sharedPreferences.getString("cart", null), Toast.LENGTH_LONG).show()
            }
        }

        var counter = 0
        val sharedPreferences: SharedPreferences? = activity?.getSharedPreferences("TDG_APP", Context.MODE_PRIVATE)
        items.forEach { i ->
            if (serviceableType === "FORMAL_WASH") {
                i.text = Gson().fromJson(
                    sharedPreferences?.getString("cart", null),
                    CartInstance::class.java
                ).formal_wash.elementAt(counter++).quantity.toString()
            } else if (serviceableType === "DRY_WASH") {
                i.text = Gson().fromJson(
                    sharedPreferences?.getString("cart", null),
                    CartInstance::class.java
                ).dry_wash.elementAt(counter++).quantity.toString()
            }
            else if (serviceableType === "STEAM_IRON") {
                i.text = Gson().fromJson(
                    sharedPreferences?.getString("cart", null),
                    CartInstance::class.java
                ).steam_iron.elementAt(counter++).quantity.toString()
            }
        }

        view.findViewById<ConstraintLayout>(R.id.navigate_back).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_fragChooseItems_to_fragHome)
        }
        return view
    }
}