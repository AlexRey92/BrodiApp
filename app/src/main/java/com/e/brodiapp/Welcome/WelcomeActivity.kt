package com.e.brodiapp.Welcome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.e.brodiapp.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WelcomeActivity : AppCompatActivity() {
    private var firstFrag: Boolean = false
    private lateinit var user: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        user = findViewById(R.id.UserNameWelcome)
        ChangeFragment()
        val preferences=getSharedPreferences("appPreferences", MODE_PRIVATE)
        val userName= preferences.getString(SHARED_PREFERENCES_USER,"")



    }

    private fun ChangeFragment() {
        GlobalScope.launch {
            if (firstFrag) {
                val fistWeather = supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, WeatherFragment()).commit()
            } else {
                val fistWeather = supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, Weather2()).commit()
            }
            firstFrag = !firstFrag
            delay(4000)
        }
    }

    companion object {
        const val SHARED_PREFERENCES_USER = "USER"
        const val SHARED_PREFERENCES_AVATAR = "AVATAR"
    }
}









