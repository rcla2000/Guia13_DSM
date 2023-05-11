package com.example.multimedia_app_la181955

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.MediaController
import android.widget.VideoView

class VideoURLActivity : AppCompatActivity() {
    private lateinit var btnCargarVideo : Button
    private lateinit var edtUrlVideo : EditText
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_urlactivity)
        cargarVideoDesdeUrl()
    }

    private fun cargarVideoDesdeUrl() {
        btnCargarVideo = findViewById<Button>(R.id.btnCargarVideo)
        edtUrlVideo = findViewById<EditText>(R.id.edtUrlVideo)
        videoView = findViewById<VideoView>(R.id.video)

        btnCargarVideo.setOnClickListener {
            if (edtUrlVideo.text.toString().isEmpty()) {
                edtUrlVideo.setError("Ingrese la URL del video que desea cargar.")
            } else {
                val uri : Uri = Uri.parse(edtUrlVideo.text.toString())
                val mediaController = MediaController(this)
                videoView.setMediaController(mediaController)
                videoView.setVideoURI(uri)
                videoView.requestFocus()
                videoView.start()
            }
        }
    }
}