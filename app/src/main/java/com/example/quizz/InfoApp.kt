package com.example.quizz

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InfoApp : AppCompatActivity() {

    lateinit var btnAula: Button
    lateinit var url: String
    lateinit var btnChollometro: Button
    lateinit var urlChollometro: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_app)

        btnAula = findViewById(R.id.btnAula)
        url = "https://aulavirtual33.educa.madrid.org/ies.goya.madrid/"
        btnChollometro = findViewById(R.id.btnChollometro)
        urlChollometro = "https://www.chollometro.com/"

        btnAula.setOnClickListener(){
            var uri = Uri.parse(url)
            intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnChollometro.setOnClickListener(){
            var uri = Uri.parse(urlChollometro)
            intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

    }
}