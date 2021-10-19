package com.devjockey.appmastery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import com.google.android.material.navigation.NavigationBarView

import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {


    //CatLog IDs
    private val catLogId1: String = "5d52df0a8c31223a0ea27db1"
    private val catLogId2: String = "5d52df458c31223a0ea27dbb"
    private val catLogId3: String = "5d52f12c8c31223a0ea27e29"

    //Fragments
    private lateinit var firstFragment: Fragment1
    private lateinit var secondFragment: Fragment1
    private lateinit var thirdFragment: Fragment1


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //UserToken For Later Use
        val userToken = intent.getStringExtra("user_token")

        //Set Fragment
        setFragment()

        //nav listener
        nav_bar.setOnItemSelectedListener(this)
    }

    private fun setFragment() {
        firstFragment = Fragment1.newInstance(catLogId1)
        secondFragment = Fragment1.newInstance(catLogId2)
        thirdFragment = Fragment1.newInstance(catLogId3)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_view, firstFragment)
            .commit()
    }


    //nav listener
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav1 -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_view, firstFragment)
                    .commit()
            }
            R.id.nav2 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_view, secondFragment)
                    .commit()
            }
            R.id.nav3 -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_view, thirdFragment)
                    .commit()
            }
            else -> {
                Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
            }
        }

        return true
    }


}