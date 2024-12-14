package com.example.explicitassignment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.explicitassignment.databinding.ActivityDisplayBinding

class DisplayActivity : AppCompatActivity() {
    lateinit var binding : ActivityDisplayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username : String = intent.getStringExtra("username").toString()
        val email : String = intent.getStringExtra("email").toString()
        val password : String = intent.getStringExtra("password").toString()
        val group : String=intent.getStringExtra("group").toString()
        val country:String=intent.getStringExtra("country").toString()
        val auto:String=intent.getStringExtra("auto").toString()
        val agree:Boolean=intent.getBooleanExtra("agree",false)

        val userInfo="""
            welcome!
            Name:$username
            Email:$email
            Gender:$group
            Country:$country
        """.trimIndent()
        binding.display.text=userInfo


        setContentView(R.layout.activity_display)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}