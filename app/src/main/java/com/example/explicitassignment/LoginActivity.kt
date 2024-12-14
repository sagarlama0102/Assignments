package com.example.explicitassignment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.explicitassignment.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(),AdapterView.OnItemClickListener {
    lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val country = listOf("Select Country ","Nepal","India","Japan")
        val countryAdapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,country)
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.country.adapter=countryAdapter

        binding.submit.setOnClickListener(){
            val username:String=binding.username.text.toString()
            val email:String=binding.email.text.toString()
            val password : String=binding.password.text.toString()
            val group : String= when(binding.gender.checkedRadioButtonId){
                binding.male.id->"Male"
                binding.female.id->"Female"
                else-> "Not sepcified"
            }
            val country:String=binding.country.selectedItem.toString()
            val auto:String=binding.auto.text.toString()
            val agree = binding.agree.isChecked

            if(!agree){
                Toast.makeText(this,"Please, Click on terms",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            if(username.isEmpty()){
                binding.username.error="Username can't be empty"
            }else if(email.isEmpty()){
                binding.email.error="Email can't be empty"
            }else if (password.isEmpty()) {
                binding.password.error = "Password can't be empty"
            }

            else{
                val intent = Intent(this@LoginActivity,DisplayActivity::class.java)
                intent.putExtra("username",username)
                intent.putExtra("email",email)
                intent.putExtra("password",password)
                intent.putExtra("group",group)
                intent.putExtra("country",country)
                intent.putExtra("auto",auto)
                intent.putExtra("agree",agree)

                startActivity(intent)

            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }


}