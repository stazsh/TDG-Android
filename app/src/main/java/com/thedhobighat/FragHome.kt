package com.thedhobighat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation

class FragHome() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.frag_home, container, false)
        view.findViewById<ConstraintLayout>(R.id.clFormalWash).setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", "FORMAL_WASH")
            Navigation.findNavController(view).navigate(R.id.action_fragHome_to_fragChooseItems, bundle)
        }

        view.findViewById<ConstraintLayout>(R.id.clDryWash).setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", "DRY_WASH")
            Navigation.findNavController(view).navigate(R.id.action_fragHome_to_fragChooseItems, bundle)
        }

        view.findViewById<ConstraintLayout>(R.id.clSteamIron).setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", "STEAM_IRON")
            Navigation.findNavController(view).navigate(R.id.action_fragHome_to_fragChooseItems, bundle)
        }
        return view
    }
}