package com.example.intentpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        returnToMainBtn.setOnClickListener {
            // 다른 화면으로 이동하기
            // Intent(출발지, 도착할 액티비티이름 :: class.java)
//            val subIntent = Intent(this, MainActivity :: class.java)
//            startActivity(subIntent)// 출발지, 도착지 정보가담긴 subIntent 넣어준다.

            finish()    // 현재화면을 꺼주세요. 현재화면에서 이전 화면으로 이동하는 효과
        }

    }
}