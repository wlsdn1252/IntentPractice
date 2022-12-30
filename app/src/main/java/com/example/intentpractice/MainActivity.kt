package com.example.intentpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 에딧텍스트에서 입력한 내용을 저장
        val inputMessageBtn = messageEdt.text.toString()

        moveToOtherBtn.setOnClickListener {

            // 다른 화면으로 이동하기
            // Intent(출발지, 도착할 액티비티이름 :: class.java)
            val myIntent = Intent(this, OtherActivity::class.java)
            startActivity(myIntent) // 출발지, 도착지 정보가담긴 myIntent를 넣어준다.
        }
        
        // 다음 화면으로 넘어가면서 에딧텍스트 값도 같이 들고가기
        sendMessageBtn.setOnClickListener {
            val myIntent = Intent(this, MessageActivity::class.java)
            // myIntent에 putExtra("사용할 이름", 넘길 값)을 첨부
            myIntent.putExtra("message", inputMessageBtn)
            startActivity(myIntent)

        }
    }
}