package com.adso.home

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SkillsActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills)


        val publicacionesTextView = findViewById<TextView>(R.id.publicacionesTextView)
        val calificacionesTextView = findViewById<TextView>(R.id.calificacionesTextView)
        val skillsTextView = findViewById<TextView>(R.id.skillsTextView)


        publicacionesTextView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        calificacionesTextView.setOnClickListener {
            val intent = Intent(this, CalificacionActivity::class.java)
            startActivity(intent)
        }
        skillsTextView.setOnClickListener {
            val intent = Intent(this, SkillsActivity::class.java)
            startActivity(intent)
        }


    }

}
