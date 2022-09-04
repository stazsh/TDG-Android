package com.thedhobighat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController

class FragSubmitYourInfo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.frag_submit_your_info, container, false)

        view.findViewById<ConstraintLayout>(R.id.navigate_back).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragSubmitYourInfo_to_fragChooseItems)
        }

        view.findViewById<ConstraintLayout>(R.id.place_order_btn).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragSubmitYourInfo_to_fragPayment)
        }
        return view
    }
}