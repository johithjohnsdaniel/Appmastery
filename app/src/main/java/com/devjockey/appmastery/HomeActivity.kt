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

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //nav listener
        nav_bar.setOnItemSelectedListener(this)

        //UserToken For Later Use
        val userToken = intent.getStringExtra("user_token")
    }


    //nav listener
    override fun onNavigationItemSelected(item: MenuItem): Boolean {


        val firstFragment = Frag1()
        val secondFragment = Frag1()
        val thirdFragment = Frag1()



        when (item.itemId) {
            R.id.nav1 -> {


                supportFragmentManager.commit {

                    replace(R.id.fragment_view, firstFragment)
                }
                Toast.makeText(this, "frag 1", Toast.LENGTH_LONG).show()
            }
            R.id.nav2 -> {
                supportFragmentManager.commit {
                    val data = Bundle()
                    data.putString("key", "5d52df458c31223a0ea27dbb")
                    secondFragment.arguments = data
                    replace(R.id.fragment_view, secondFragment)
                }
                Toast.makeText(this, "frag 2", Toast.LENGTH_LONG).show()

            }
            R.id.nav3 -> {
                supportFragmentManager.commit {

                    val data = Bundle()
                    data.putString("key", "5d52f12c8c31223a0ea27e29")
                    thirdFragment.arguments = data
                    replace(R.id.fragment_view, thirdFragment)
                }
                Toast.makeText(this, "frag 3", Toast.LENGTH_LONG).show()

            }
            else -> {
                Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
            }
        }

        return true
    }


}