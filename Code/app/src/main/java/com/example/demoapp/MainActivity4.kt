package com.example.demoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        supportActionBar?.hide()

        val getdetailsc: Button = findViewById(R.id.get_details_c)
        val homeButton: Button = findViewById(R.id.Home_Button)
        val companyname: EditText =findViewById(R.id.company_name_input)


        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        getdetailsc.setOnClickListener {
            if(companyname.text.toString().isNotEmpty()) {
                val intent = Intent(this, MainActivity5::class.java)
                intent.putExtra("company_name", companyname.text.toString().toLowerCase())
                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext,"Enter Company Name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}