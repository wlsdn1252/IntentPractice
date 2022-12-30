package com.example.intentpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_message.*

class MessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        // 화면에 들어올때 첨부된 데이터를 덱스트뷰에 반영
        // 메인 액티비티에서 String형태로 보낸 메세지를 받음 name은 동일해야 함
        val intentMessage = intent.getStringExtra("message")

        receivedMessageTxt.text = intentMessage
    }
}