package com.adso.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.adso.home.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.nav_open, R.string.nav_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationDrawer.setNavigationItemSelectedListener(this)

        binding.bottomNavigation.background = null
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.bottom_home -> openFragment(HomeFragment())
                R.id.bottom_profile -> openFragment(ProfileFragment())
                R.id.bottom_chat -> openFragment(ChatFragment())
                R.id.bottom_notification -> openFragment(NotificatonFragment())
            }
            true
        }

        fragmentManager = supportFragmentManager
        openFragment(HomeFragment())

       binding.fab.setOnClickListener {
           val popup = PopupMenu(this,it)
           menuInflater.inflate(R.menu.publication_menu,popup.menu)

           popup.show()
           popup.setOnMenuItemClickListener(::manageItemClick)
       }


    }

    private  fun manageItemClick(menuItem: MenuItem): Boolean {
        return when (menuItem?.itemId){
            R.id.ajustes -> {
                Toast.makeText(this, "copiar", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.opc1 -> {
                Toast.makeText(this, "copiar", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_ajustes -> openFragment(AjustesFragment())
            R.id.nav_opc1 -> openFragment(Opc1Fragment())
            R.id.nav_opc2 -> openFragment(Opc2Fragment())
            R.id.nav_opc3 -> Toast.makeText(this,"opc3",Toast.LENGTH_SHORT).show()
            R.id.nav_opc4 -> Toast.makeText(this,"opc4",Toast.LENGTH_SHORT).show()
            R.id.nav_opc5 -> Toast.makeText(this,"opc5",Toast.LENGTH_SHORT).show()
        }
      binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {

        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
        }
        super.onBackPressed()

    }





    private  fun openFragment(fragment: Fragment){
      val   fragmentTransaction: FragmentTransaction  = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }
}

