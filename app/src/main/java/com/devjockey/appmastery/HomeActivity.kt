package com.devjockey.appmastery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.commit
import com.google.android.material.navigation.NavigationBarView

import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //nav listener
        nav_bar.setOnItemSelectedListener(this)


    }



    //nav listener
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav1 -> {
                supportFragmentManager.commit {
                    replace(R.id.fragment_view, Frag1())
                }
                return true
            }
            R.id.nav2 -> {
                supportFragmentManager.commit {
                    replace(R.id.fragment_view, Frag2())
                }
                return true
            }
            R.id.nav3 -> {
                supportFragmentManager.commit {
                    replace(R.id.fragment_view, Frag3())
                }
                return true
            }
            else -> {
                return false
            }
        }
    }


}