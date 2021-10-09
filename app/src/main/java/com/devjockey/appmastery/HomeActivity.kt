package com.devjockey.appmastery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
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
        val userToken=intent.getStringExtra("user_token");
        Toast.makeText(this,userToken,Toast.LENGTH_SHORT).show()

    }



    //nav listener
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

//        //Incomplete
//        val fragRef1=Frag1();
//        val fragRef2=Frag1();
//        val fragRef3=Frag1();

        when (item.itemId) {
            R.id.nav1 -> {
                supportFragmentManager.commit {
                    replace(R.id.fragment_view, Frag1())
                }
                return true
            }
            R.id.nav2 -> {
                supportFragmentManager.commit {
                    replace(R.id.fragment_view, Frag1())
                }
                return true
            }
            R.id.nav3 -> {
                supportFragmentManager.commit {
                    replace(R.id.fragment_view, Frag1())
                }
                return true
            }
            else -> {
                return false
            }
        }
    }


}