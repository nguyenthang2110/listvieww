package com.example.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val main = findViewById<ConstraintLayout>(R.id.main)
        val items=mutableListOf<String>()
//
        for(i in 1..50) items.add("Item $i")

        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            R.layout.layout_item,
            R.id.text_content,
            items)

//        val listView=findViewById<ListView>(R.id.listview)
//        listView.adapter=adapter

        val spinner1 = findViewById<Spinner>(R.id.spinner)()

        spinner1.adapter=adapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //notificedatasetchanged
    }
}