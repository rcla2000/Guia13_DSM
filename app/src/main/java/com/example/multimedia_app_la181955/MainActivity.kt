package com.example.multimedia_app_la181955

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    var menu = arrayOf(
        "Audio",
        "Video",
        "Camara",
        "TextToSpeech",
        "Video desde URL"
    )
    var activities = arrayOf(
        "AudioActivity",
        "VideoActivity",
        "CamaraActivity",
        "TextToSpeechActivity",
        "VideoURLActivity"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, menu
        )
        val listView: ListView = findViewById(R.id.listview_1)
        listView.setAdapter(adapter)
        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>, view: View,
                position: Int, id: Long
            ) {
                var nombreClase = activities[position]
                try {
                    var activity =
                        Class.forName("com.example.multimedia_app_la181955.$nombreClase")
                    var numbersIntent = Intent(this@MainActivity, activity)
                    startActivity(numbersIntent)
                } catch (e: ClassNotFoundException) {
                    e.printStackTrace()
                }
            }
        }
    }
}