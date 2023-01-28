package com.e.brodiapp.LOGIN

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.e.brodiapp.R
import com.e.brodiapp.Welcome.WelcomeActivity


class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var userEditText:EditText
    private lateinit var passwordEditText:EditText
    private lateinit var buttonCreate:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.button)
        userEditText=findViewById(R.id.editTextUser)
        passwordEditText=findViewById(R.id.EditPassword)
        buttonCreate=findViewById(R.id.buttonCreateUser)
        LogIn()
        navigatoCreateUser()
        CheckUserPermissions()
    }// 39, clase 9

    private fun CheckUserPermissions() {
        val preferences= getSharedPreferences("appPreferences", MODE_PRIVATE)
       var name=preferences.getString(SHARED_PREFERENCES_USER,"")
        var password= preferences.getString(SHARED_PREFERENCES_PASSWORD,"")
        if (!name.isNullOrEmpty() && !password.isNullOrEmpty()){
            name= userEditText.text.toString()
            password=passwordEditText.text.toString()
        } else{
            LogIn()
        } }


    private fun navigatoCreateUser() {
        buttonCreate.setOnClickListener{
        val intent = Intent(this, CreateUser::class.java)
        startActivity(intent)
         }
    }


    private fun LogIn() {
        CheckUserPermissions()
        var user= userEditText.text?.toString()
        var password= passwordEditText.text?.toString()
        button.setOnClickListener {
            if(user.isNullOrEmpty() || password.isNullOrEmpty()){
                val toastView= findViewById<ConstraintLayout>(R.id.ToastLayout)
                val layaoutToast:View=layoutInflater.inflate(R.layout.toast_layout,toastView)
                Toast(this).apply {
                    duration=Toast.LENGTH_SHORT
                    view= layaoutToast
                }.show()
            } else{
                val preferences=getSharedPreferences( "appPreferences", MODE_PRIVATE)
                user= preferences.getString(SHARED_PREFERENCES_USER,"")
                password=preferences.getString(SHARED_PREFERENCES_USER,"")
                val intent = Intent (this, WelcomeActivity::class.java)
                startActivity(intent)




            }
        }

    }
    companion object {
        const val SHARED_PREFERENCES_USER = "USER"
        const val SHARED_PREFERENCES_PASSWORD = "PASSWORD"
        const val SHARED_PREFERENCES_AVATAR ="AVATAR"

    }


    }

