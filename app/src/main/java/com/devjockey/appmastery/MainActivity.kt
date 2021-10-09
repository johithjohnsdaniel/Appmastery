package com.devjockey.appmastery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.devjockey.appmastery.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //btn Listener
        binding.btnLogin.setOnClickListener { onclickLogin() }

    }

    //Functions

    private fun onclickLogin() {

        username = binding.username.text.toString();
        val password = binding.password.text.toString();

        //Encrypting Password =()=>{}
        //To be Implemented

        //Log In Function
        loginCheck()

    }

    private fun loginCheck() {

        val loginRequest = LoginRequest(
            username,
            "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92"
        )

        //Validation Function to be implemented

        val resultCall: Call<ResultLogin> = ApiClientLogin.getLoginService().loginIn(loginRequest)
        resultCall.enqueue(object : Callback<ResultLogin?> {
            override fun onResponse(call: Call<ResultLogin?>?, response: Response<ResultLogin?>) {

                if (response.isSuccessful) {

                    val resultLogin: ResultLogin? = response.body();

                    Log.e("MainActivity",
                        "Response = " + resultLogin?.getResponse()?.getUser_token());

                    val user_token = resultLogin?.getResponse()?.getUser_token();

                    val intentRef = Intent(this@MainActivity, HomeActivity::class.java);
                    //Passing userToken
                    intentRef.putExtra("user_token", user_token);
                    startActivity(intentRef)

                    Toast.makeText(this@MainActivity,
                        "Login Success" + user_token,
                        Toast.LENGTH_SHORT).show()


                } else {
                    Toast.makeText(this@MainActivity, "check your credentials", Toast.LENGTH_SHORT)
                        .show()
                }

            }

            override fun onFailure(call: Call<ResultLogin?>?, t: Throwable?) {
                Log.e("MainActivity", "Error")
            }
        })
    }


}