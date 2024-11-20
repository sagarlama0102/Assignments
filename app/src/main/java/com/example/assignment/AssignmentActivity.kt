package com.example.assignment

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class AssignmentActivity : AppCompatActivity() {
    lateinit var firstname: TextInputLayout
    lateinit var lastname: TextInputLayout
    lateinit var email: TextInputLayout
    lateinit var password : TextInputLayout
    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_assignment)
        firstname =findViewById(R.id.firstname)
        lastname = findViewById(R.id.lastname)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        button = findViewById(R.id.signup)

        button.setOnClickListener(){
            val firstName = firstname.editText?.text.toString()
            val lastName = lastname.editText?.text.toString()
            val emailInput = email.editText?.text.toString()
            val passwordInput = password.editText?.text.toString()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}