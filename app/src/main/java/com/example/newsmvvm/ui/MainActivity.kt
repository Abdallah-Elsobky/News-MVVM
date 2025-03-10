package com.example.newsmvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsmvvm.R
import com.example.newsmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var toolbar: Toolbar
//    private lateinit var drawerLayout: DrawerLayout
//    private lateinit var navigationView: NavigationView
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigation()
    }

    private fun navigation(){
        setSupportActionBar(binding.toolbar.toolbar)

        navController = findNavController(R.id.fragmentContainerView)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.id_category_fragment, R.id.id_setting_fragment),
            binding.drawer
        )
        setupActionBarWithNavController(navController, binding.drawer)
        binding.navigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}