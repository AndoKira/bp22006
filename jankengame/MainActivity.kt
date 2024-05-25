package com.example.jankengame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random
import kotlin.random.Random as Random1

class MainActivity : AppCompatActivity() {
    val te= arrayOf("✊","✌","✋")
    private var comp:Int = 0
    private var result= arrayOf(0,0,0)
    private var time=result.sum()+1
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val tvjan:TextView=findViewById(R.id.tvjan)
        val tvte:TextView=findViewById(R.id.tvte)
        val btngu:Button=findViewById(R.id.btngu)
        val btntyo:Button=findViewById(R.id.btntyo)
        val btnpa:Button=findViewById(R.id.btnpa)
        val btnstart:Button=findViewById(R.id.btnstart)
        btngu.isEnabled=false
        btntyo.isEnabled=false
        btnpa.isEnabled=false

        btnstart.setOnClickListener {
        tvjan.text="第"+time+"回戦"
            tvte.text="じゃんけん・・ポン"
            comp= Random().nextInt(3)

            btngu.isEnabled=true
            btntyo.isEnabled=true
            btnpa.isEnabled=true
        }
        btngu.setOnClickListener {
            tvte.text= te[comp]

            JUDGE(0)
            btngu.isEnabled=false
            btntyo.isEnabled=false
            btnpa.isEnabled=false
        }

        btntyo.setOnClickListener {
            tvte.text= te[comp]
            JUDGE(1)

            btngu.isEnabled=false
            btntyo.isEnabled=false
            btnpa.isEnabled=false
        }

        btnpa.setOnClickListener {
            tvte.text= te[comp]
            JUDGE(2)

            btngu.isEnabled=false
            btntyo.isEnabled=false
            btnpa.isEnabled=false
        }

    }
    fun JUDGE(me:Int){
        val judge=(me-comp+3)%3
        result[judge]++
        time++

        if(time==6) {
           /*  AlertDialog.Builder(this)
                 .setTitle("結果発表！！")
                 .setMessage(result[0].toString()+"勝"+result[1].toString()+"敗"+result[2].toString()+"分け")
                 .setPositiveButton("OK",null)
                 .show()*/
            val intent=Intent(this,SecondPage::class.java)
            val bandle=Bundle()
            bandle.putString("win",result[0].toString())
            bandle.putString("lose",result[1].toString())
            bandle.putString("draw",result[2].toString())
            intent.putExtra("bundle",bandle)
            startActivity(intent)

        }
    }
}