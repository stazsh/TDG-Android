package com.thedhobighat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation

class FragTrackYourOrder : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.frag_track_your_order, container, false)

        view.findViewById<ConstraintLayout>(R.id.navigate_back).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragTrackYourOrder_to_fragPayment)
        }

        return view
    }
}