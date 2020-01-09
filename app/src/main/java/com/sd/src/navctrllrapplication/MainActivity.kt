package com.sd.src.navctrllrapplication

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.IdRes
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomTabs.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(it: MenuItem): Boolean {
        when (it.itemId) {
            R.id.navigation_shop -> {
                Navigation.findNavController(this@MainActivity, R.id.nav_host)
                    .navigate(R.id.action_homeFragment_to_homeFragment)
            }
            R.id.navigation_cart -> {
                var bundle = bundleOf("myArg" to "Arguments passed from Home fragment")
                Navigation.findNavController(this@MainActivity, R.id.nav_host)
                    .navigate(R.id.action_homeFragment_to_profileFragment, bundle)
//                    Navigation.findNavController(nav_host).navigate(R.id.action_homeFragment_to_profileFragment, bundle)
//                    NavHostFragment.findNavController(this).navigate(R.id.action_homeFragment_to_profileFragment)

            }
            R.id.navigation_gifts -> {
                Navigation.findNavController(this@MainActivity, R.id.nav_host)
                    .navigate(R.id.action_homeFragment_to_categoriesFragment)

            }
        }
        return false
    }

}
