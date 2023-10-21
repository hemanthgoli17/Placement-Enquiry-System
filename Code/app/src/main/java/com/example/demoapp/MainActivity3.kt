package com.example.demoapp

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        supportActionBar?.hide()

        val textView6: TextView =findViewById(R.id.textView6)
        val button2: Button = findViewById(R.id.back_button)
        val Student_Image: ImageView =findViewById(R.id.student_image)
        val Student_Name: TextView =findViewById(R.id.textView3)
        val Student_Branch: TextView =findViewById(R.id.textView5)
        val Student_CGPA: TextView =findViewById(R.id.textView10)


//        val intentValue=intent.getStringExtra("Student_roll")
//        textView6.apply { text=intentValue.toString() }

        //To display roll number of the student entered in first activity
        val roll_number: String? =intent.getStringExtra("Student_roll")
        textView6.text=roll_number

        //To display student image using roll number entered in first activity
        val storageReference= FirebaseStorage.getInstance().getReference("images/$roll_number.JPG")
        val localfile: File = File.createTempFile("tempfile",".jpg")
        storageReference.getFile(localfile).addOnSuccessListener {
            val bitmap: Bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
            Student_Image.setImageBitmap(bitmap)
        }.addOnFailureListener {
            Toast.makeText(applicationContext,"Cannot get the required imaage", Toast.LENGTH_SHORT).show()
        }

        //To display Student name, Student Branch, Student CGPA

        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val databaseReference=database.getReference("17-21 batch")
        if (roll_number != null) {
            databaseReference.child(roll_number).child("student name").addValueEventListener(object:
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()) {
                        //Log.d("student name", snapshot.getValue().toString())
                        Student_Name.text=snapshot.getValue().toString();
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })

            databaseReference.child(roll_number).child("student branch").addValueEventListener(object:
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()) {
                        //Log.d("student name", snapshot.getValue().toString())
                        Student_Branch.text=snapshot.getValue().toString();
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })

            databaseReference.child(roll_number).child("student cgpa").addValueEventListener(object:
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()) {
                        //Log.d("student name", snapshot.getValue().toString())
                        Student_CGPA.text=snapshot.getValue().toString();
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        }


        //To display Company name and Package
        val companyname1: TextView =findViewById(R.id.companyname1)
        val companyname2: TextView =findViewById(R.id.companyname2)
        val companyname3: TextView =findViewById(R.id.companyname3)
        val companyname4: TextView =findViewById(R.id.companyname4)
        val companyname5: TextView =findViewById(R.id.companyname5)
        val companyname6: TextView =findViewById(R.id.companyname6)
        val companyname7: TextView =findViewById(R.id.companyname7)
        val package1: TextView =findViewById(R.id.package1)
        val package2: TextView =findViewById(R.id.package2)
        val package3: TextView =findViewById(R.id.package3)
        val package4: TextView =findViewById(R.id.package4)
        val package5: TextView =findViewById(R.id.package5)
        val package6: TextView =findViewById(R.id.package6)
        val package7: TextView =findViewById(R.id.package7)



        if (roll_number != null) {
            databaseReference.child(roll_number).child("placement offers").addValueEventListener(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists())
                    {
                        var count:Int=0
                        var companies : MutableList<String> = mutableListOf<String>()
                        var packages : MutableList<String> = mutableListOf<String>()
                        for(i in snapshot.children)
                        {
                            count++
                            //Log.d("count: ","${count}")
                            //Log.d("details","company name: ${i.key.toString()}, package: ${i.getValue().toString()}")
                            companies.add(i.key.toString())
                            packages.add(i.getValue().toString())
                        }
                        //Log.d("company names","${companies[1]} : ${packages[1]}")
                        when(count){
                            0 ->{
                                Toast.makeText(applicationContext,"No placement offers", Toast.LENGTH_LONG).show()
                            }

                            1->{
                                companyname1.text=companies[0]
                                package1.text=packages[0]
                            }
                            2->{
                                companyname1.text=companies[0]
                                package1.text=packages[0]

                                companyname2.text=companies[1]
                                package2.text=packages[1]
                            }
                            3 ->{
                                companyname1.text=companies[0]
                                package1.text=packages[0]

                                companyname2.text=companies[1]
                                package2.text=packages[1]

                                companyname3.text=companies[2]
                                package3.text=packages[2]
                            }
                            4->{
                                companyname1.text=companies[0]
                                package1.text=packages[0]

                                companyname2.text=companies[1]
                                package2.text=packages[1]

                                companyname3.text=companies[2]
                                package3.text=packages[2]

                                companyname4.text=companies[3]
                                package4.text=packages[3]
                            }
                            5->{
                                companyname1.text=companies[0]
                                package1.text=packages[0]

                                companyname2.text=companies[1]
                                package2.text=packages[1]

                                companyname3.text=companies[2]
                                package3.text=packages[2]

                                companyname4.text=companies[3]
                                package4.text=packages[3]

                                companyname5.text=companies[4]
                                package5.text=packages[4]
                            }
                            6->{
                                companyname1.text=companies[0]
                                package1.text=packages[0]

                                companyname2.text=companies[1]
                                package2.text=packages[1]

                                companyname3.text=companies[2]
                                package3.text=packages[2]

                                companyname4.text=companies[3]
                                package4.text=packages[3]

                                companyname5.text=companies[4]
                                package5.text=packages[4]

                                companyname6.text=companies[5]
                                package6.text=packages[5]
                            }
                            7->{
                                companyname1.text=companies[0]
                                package1.text=packages[0]

                                companyname2.text=companies[1]
                                package2.text=packages[1]

                                companyname3.text=companies[2]
                                package3.text=packages[2]

                                companyname4.text=companies[3]
                                package4.text=packages[3]

                                companyname5.text=companies[4]
                                package5.text=packages[4]

                                companyname6.text=companies[5]
                                package6.text=packages[5]

                                companyname7.text=companies[6]
                                package7.text=packages[6]
                            }
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

        }
        button2.setOnClickListener {
            // Do something in response to button click
            val intent1 = Intent(this, MainActivity2::class.java)
            startActivity(intent1)
        }
    }
}