package com.example.intentpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToOtherBtn.setOnClickListener {

            // 다른 화면으로 이동하기
            // Intent(출발지, 도착지)
            val myIntent = Intent(this, OtherActivity::class.java)
            startActivity(myIntent) // 출발지, 도착지 정보가담긴 myIntent를 넣어준다.
        }
    }
}