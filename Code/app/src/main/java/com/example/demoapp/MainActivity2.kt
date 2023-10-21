
package com.example.demoapp

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.util.Log
import android.widget.*
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.*
import com.google.firebase.storage.FileDownloadTask
import com.google.firebase.storage.FirebaseStorage
import org.w3c.dom.Text
import java.io.File


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val get_details: Button = findViewById(R.id.button)
        val home_button: Button = findViewById(R.id.home_button)
        val rollnumberfield: EditText =findViewById(R.id.textfield1)

        get_details.setOnClickListener {

            if(rollnumberfield.text.toString().isNotEmpty()) {
//            val intent=Intent(this,MainActivity2::class.java).apply {
//                putExtra("Student_roll",rollnumberfield.text.toString())

                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("Student_roll", rollnumberfield.text.toString().toUpperCase())
                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext,"Enter Roll Number",Toast.LENGTH_SHORT).show()
            }
        }

        home_button.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
        }
    }
}
