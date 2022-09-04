package com.thedhobighat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation

class FragChooseItems : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.frag_choose_items, container, false)

        view.findViewById<Button>(R.id.blazer_up).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.blazer_count)
            val newCount = Integer.parseInt(item.text.toString()) - 1
            item.text = newCount.toString()
        }
        view.findViewById<Button>(R.id.blazer_down).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.blazer_count)
            val newCount = Integer.parseInt(item.text.toString()) + 1
            item.text = newCount.toString();
        }

        view.findViewById<Button>(R.id.shirt_up).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.shirt_count)
            val newCount = Integer.parseInt(item.text.toString()) - 1
            item.text = newCount.toString()
        }
        view.findViewById<Button>(R.id.shirt_down).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.shirt_count)
            val newCount = Integer.parseInt(item.text.toString()) + 1
            item.text = newCount.toString()
        }

        view.findViewById<Button>(R.id.pant_up).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.pant_count)
            val newCount = Integer.parseInt(item.text.toString()) - 1
            item.text = newCount.toString()
        }
        view.findViewById<Button>(R.id.pant_down).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.pant_count)
            val newCount = Integer.parseInt(item.text.toString()) + 1
            item.text = newCount.toString()
        }

        view.findViewById<Button>(R.id.saree_up).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.saree_count)
            val newCount = Integer.parseInt(item.text.toString()) - 1
            item.text = newCount.toString()
        }
        view.findViewById<Button>(R.id.saree_down).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.saree_count)
            val newCount = Integer.parseInt(item.text.toString()) + 1
            item.text = newCount.toString()
        }

        view.findViewById<Button>(R.id.ladup_up).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.ladup_count)
            val newCount = Integer.parseInt(item.text.toString()) - 1
            item.text = newCount.toString()
        }
        view.findViewById<Button>(R.id.ladup_down).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.ladup_count)
            val newCount = Integer.parseInt(item.text.toString()) + 1
            item.text = newCount.toString()
        }

        view.findViewById<Button>(R.id.laddown_up).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.laddown_count)
            val newCount = Integer.parseInt(item.text.toString()) - 1
            item.text = newCount.toString()
        }
        view.findViewById<Button>(R.id.laddown_down).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.laddown_count)
            val newCount = Integer.parseInt(item.text.toString()) + 1
            item.text = newCount.toString()
        }

        view.findViewById<Button>(R.id.others_up).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.others_count)
            val newCount = Integer.parseInt(item.text.toString()) - 1
            item.text = newCount.toString()
        }
        view.findViewById<Button>(R.id.others_down).setOnClickListener{
            val item = view.findViewById<TextView>(R.id.others_count)
            val newCount = Integer.parseInt(item.text.toString()) + 1
            item.text = newCount.toString()
        }

        view.findViewById<ConstraintLayout>(R.id.process_order_btn).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_fragChooseItems_to_fragSubmitYourInfo)
        }

        view.findViewById<ConstraintLayout>(R.id.navigate_back).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_fragChooseItems_to_fragHome)
        }
        return view
    }
}