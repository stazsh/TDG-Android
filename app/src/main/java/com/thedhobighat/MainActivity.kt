package com.thedhobighat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setCurrentFragment(FragHome())
                R.id.cart -> setCurrentFragment(FragCart())
                R.id.profile -> setCurrentFragment(FragProfile())
                R.id.orders -> setCurrentFragment(FragOrderHistory())
                else -> { setCurrentFragment(FragHome()) }
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                R.anim.slide_in_from_right,
                R.anim.slide_in_from_left,
                R.anim.slide_in_from_right,
                R.anim.slide_in_from_left
            )
            replace(R.id.main_fragment, fragment)
            addToBackStack(null)
            commit()
        }
    }
}