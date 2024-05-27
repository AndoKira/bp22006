package com.example.jankengame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jankengame.R.id.result

class SecondPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_page)

        val Res:TextView=findViewById(R.id.result)
        val btnback:Button=findViewById(R.id.btnback)

        val bundle=intent.getBundleExtra("bundle")
        val win= bundle?.getString("win")
        val lose= bundle?.getString("lose")

        Res.text=win+"勝"+lose+"敗"

        btnback.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
