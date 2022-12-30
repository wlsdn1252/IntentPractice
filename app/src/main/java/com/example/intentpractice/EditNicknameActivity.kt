package com.example.intentpractice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)


        okBtn.setOnClickListener {
            // 입력한 새 닉네임이 뭔지 변수로 저장
            val inputNewNickname = newNicknameEdt.text.toString()

            // 입력한 닉네임을 가지고 메인화면으로 복귀
            // 입력한 닉네임을 담아주기위한 용도로만 사용하는 Intent
            val resultIntent = Intent()

            // 메인화면으로 돌아가는데 이름은 nickName으로하고 가져갈 값은 inputNewNickname로 가져간다.
            resultIntent.putExtra("neckName", inputNewNickname)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()

        }

    }
}