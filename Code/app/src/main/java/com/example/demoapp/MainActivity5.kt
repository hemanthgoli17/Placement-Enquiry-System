package com.example.demoapp

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_main5.*
import java.io.File

class MainActivity5 : AppCompatActivity() {

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val databaseReference = database.getReference("17-21 batch")

    val array1: MutableList<String> = mutableListOf<String>()
    val array2: MutableList<String> = mutableListOf<String>()
    val array3: MutableList<Bitmap> = mutableListOf<Bitmap>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        supportActionBar?.hide()

        home_button_activity5.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }

        lateinit var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
        lateinit var layoutManager: RecyclerView.LayoutManager

        val company: String? = intent.getStringExtra("company_name")
        company_name_description.text = company

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        traineeDetailsRecyclerView.layoutManager = layoutManager


//
        databaseReference.child("company wise").child(company.toString())
            .addValueEventListener(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {

                        for (i in snapshot.children) {
                            array1.add(i.key.toString())
                            array2.add(i.getValue().toString())
//                            val storageReference = FirebaseStorage.getInstance()
//                                .getReference("images/$i.key.toString().jpg")
//                            val localfile: File = File.createTempFile("$i.key.toString()", ".jpg")
//                            storageReference.getFile(localfile).addOnSuccessListener {
//                                val bitmap: Bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
//                                array3.add(bitmap)
                        }

                        adapter = RecyclerAdapter(array1, array2)
                        traineeDetailsRecyclerView.adapter = adapter
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
    }
}


