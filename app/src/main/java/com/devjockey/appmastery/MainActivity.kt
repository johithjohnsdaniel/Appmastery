package com.devjockey.appmastery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.devjockey.appmastery.databinding.ActivityMainBinding
import com.google.common.hash.HashCode
import com.google.common.hash.HashFunction
import com.google.common.hash.Hashing
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {

    companion object {

        lateinit var userToken: String
        lateinit var ePassword: String
        lateinit var password: String


    }

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

        username = binding.username.text.toString()

        password = binding.password.text.toString()

        ePassword = encryptPass()

        //Log In Function
        loginCheck()

    }

    private fun encryptPass(): String {

        val hashFunction: HashFunction = Hashing.sha256();
        val hc: HashCode = hashFunction
            .newHasher()
            .putString(password, Charsets.UTF_8)
            .hash();
        val sha256: String = hc.toString()
        return sha256


    }

    private fun loginCheck() {

        val loginRequest = LoginRequest(
            username,
            ePassword
        )

        //Validation Function to be implemented =()=>

        val resultCall: Call<ResultLogin> = ApiClientLogin.getLoginService().loginIn(loginRequest)
        resultCall.enqueue(object : Callback<ResultLogin?> {
            override fun onResponse(call: Call<ResultLogin?>?, response: Response<ResultLogin?>) {

                if (response.isSuccessful) {

                    val resultLogin: ResultLogin? = response.body()
                    val user_token = resultLogin?.getResponse()?.getUser_token()
                    if (user_token != null) {
                        userToken = user_token
                    }


                    val intentRef = Intent(this@MainActivity, HomeActivity::class.java)
                    //Passing userToken
                    intentRef.putExtra("user_token", userToken)
                    startActivity(intentRef)


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