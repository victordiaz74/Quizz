package com.example.quizz

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InfoApp : AppCompatActivity() {

    lateinit var btnLink: Button
    lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_app)

        btnLink = findViewById(R.id.btnAula)
        url = "https://aulavirtual33.educa.madrid.org/ies.goya.madrid/"

        btnLink.setOnClickListener(){
            var uri = Uri.parse(url)
            intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

    }
}