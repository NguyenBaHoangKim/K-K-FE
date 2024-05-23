package com.example.k_k_application

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.k_k_application.fragment.dashboard.DashboardFragment
import com.example.k_k_application.fragment.home.HomeFragment
import com.example.k_k_application.fragment.user.UserFragment

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigatorView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        setContentView(R.layout.bottom_navigator)
        bottomNavigatorView = findViewById(R.id.bottom_navigator)

        //val navView: BottomNavigationView = binding.navView

        bottomNavigatorView.setOnItemSelectedListener { meniItem ->
            when (meniItem.itemId) {
                R.id.navigation_home -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.navigation_dashboard -> {
                    replaceFragment(DashboardFragment())
                    true
                }
                //đổi lại thành SearchFragment()/LocationDetail()
                R.id.navigation_notifications -> {
                    replaceFragment(UserFragment())
                    true
                }

                else -> false
            }
        }
        replaceFragment(HomeFragment())
    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)

}