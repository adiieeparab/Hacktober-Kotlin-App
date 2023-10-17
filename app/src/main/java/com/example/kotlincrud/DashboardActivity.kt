package com.example.kotlincrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {
    private lateinit var bottomNavigationBar : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        bottomNavigationBar = findViewById(R.id.bottomNavBar)
//        bottomNavigationBar.menu.get(bottomNavigationBar.selectedItemId).isChecked
        bottomNavigationBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.profile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }



    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()

    }
}