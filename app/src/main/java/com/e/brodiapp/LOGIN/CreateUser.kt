package com.e.brodiapp.LOGIN


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.e.brodiapp.BrodiAdapter
import com.e.brodiapp.Welcome.OnAvatarListener
import com.e.brodiapp.R

class CreateUser : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BrodiAdapter
    private lateinit var userEdit: EditText
    private lateinit var passwordEdit: EditText
    private lateinit var buttonCreateUser: Button
    private lateinit var terms: TextView
    private lateinit var checkBox: CheckBox
    private lateinit var listener: OnAvatarListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user2)
        recyclerView = findViewById(R.id.recyclerView)
        passwordEdit = findViewById(R.id.textInputEditTextCreatePass)
        userEdit = findViewById(R.id.textInputEditTextCreateUser)
        buttonCreateUser = findViewById(R.id.ButtonCrearUsuario)
        terms = findViewById(R.id.textViewTerms)
        checkBox=findViewById(R.id.checkbox)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = BrodiAdapter()
        recyclerView.adapter = adapter
        ListOfBrodis()
        val listofBOrdis = ListOfBrodis()
        adapter.submitList(listofBOrdis)
        userCreated()
        NavigatoTerms()


    }

    private fun NavigatoTerms() {
            terms.setOnClickListener {
                val intent = Intent(this, BrodiTerms::class.java)
                startActivity(intent)
                finish()
            } }

        private fun userCreated() {
            buttonCreateUser.setOnClickListener {
                if (!(!userEdit.text.isNullOrEmpty() && !passwordEdit.text.isNullOrEmpty() && checkBox.isChecked)) {
                    Toast.makeText(this, "Completar Datos y Aceptar Términos", Toast.LENGTH_SHORT).show()
                } else {
                    val user = userEdit.text?.toString()
                    val password = passwordEdit.text?.toString()
                    adapter.onItemClickListener = {
                        listener.onAvatarSelected { it }
                    }
                    val preferences = getSharedPreferences("appPreferences", MODE_PRIVATE)
                    val nameEditor = preferences.edit().putString(SHARED_PREFERENCES_USER, user)
                    val passwordEditor = preferences.edit().putString(SHARED_PREFERENCES_PASSWORD, password)
                    nameEditor.apply()
                    passwordEditor.apply()
                    val intent=  Intent(this,MainActivity::class.java)
                    startActivity(intent)

                }
            }
        }

        private fun ListOfBrodis(): MutableList<ProfilePicture> {
            return mutableListOf(
                ProfilePicture("1", ProfilePicture.picture.TUDENTS),
                ProfilePicture("2", ProfilePicture.picture.BOCA),
                ProfilePicture("3", ProfilePicture.picture.SMALL),
                ProfilePicture("4", ProfilePicture.picture.TALL),
                ProfilePicture("5", ProfilePicture.picture.NICEGUY),
                ProfilePicture("6", ProfilePicture.picture.IMPOSTOR)
            )
        }
        companion object {
            const val SHARED_PREFERENCES_USER = "USER"
            const val SHARED_PREFERENCES_PASSWORD = "PASSWORD"
            const val SHARED_PREFERENCES_AVATAR ="AVATAR"

        }
    }

