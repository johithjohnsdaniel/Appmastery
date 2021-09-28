package com.devjockey.appmastery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.devjockey.appmastery.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //btn Listener
        binding.btnLogin.setOnClickListener { onClick() }


    }

    //onClick Btn
    private fun onClick() {

        val check = CheckLogin(binding.textInputEditName.text.toString(),
            binding.textInputEditPassword.text.toString()
        )

        //Validation
        val validation = check.validation();

        if (validation) {
            //Output Validation
            val checkop = check.checkLogin()
            if (checkop) {
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                //Intent To HomeActivity
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                Toast.makeText(this, "Check your credentials", Toast.LENGTH_SHORT).show()

            }

        } else {

            Toast.makeText(this, "Fields are required", Toast.LENGTH_SHORT).show()

        }


    }
}