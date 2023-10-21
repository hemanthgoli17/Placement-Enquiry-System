package com.example.demoapp


import android.graphics.Bitmap
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.RecyclerAdapter.ViewHolder



import android.widget.TextView as TextView


class RecyclerAdapter(private val ar1:MutableList<String>,
                      private val ar2:MutableList<String>) : RecyclerView.Adapter<ViewHolder>() {

    //val array1 : Array<String> = arrayOf("17BQ1A0501","17BQ1A0502","17BQ1A0503","17BQ1A0504","17BQ1A0505","17BQ1A0506","17BQ1A0507")
    //val array2 : Array<String> = arrayOf("5LPA","6LPA","12LPA","7LPA","5.5LPA","12LPA","8.5LPA")

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var snumber : TextView
        var salary : TextView

        init {
           snumber = itemView.findViewById(R.id.trainee_name)
           salary = itemView.findViewById(R.id.trainee_package)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.mylayout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.snumber.text=ar1[position]
        holder.salary.text=ar2[position]

    }

    override fun getItemCount(): Int {
        return ar1.size
    }
}

