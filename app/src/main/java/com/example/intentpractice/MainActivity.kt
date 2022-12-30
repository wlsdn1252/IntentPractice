package com.example.intentpractice

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 닉네임인것을 쉽게 구별하기위한 숫자를 담은 변수
    val REQUEST_FOR_NICKNAME = 1005
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Dial 액션 예제(전화걸기 직전)
        dialBtn.setOnClickListener {
            // phoneNumEdt에 입력한 전화번호를 받아서 해당 번호에 전화 연결
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")

            val myIntent = Intent(Intent.ACTION_DIAL, myUri)
            startActivity(myIntent)
        }

        // Dial 액션 예제 (전화연결 까지)
        callBtn.setOnClickListener {
            // phoneNumEdt에 입력한 전화번호를 받아서 해당 번호에 전화 연결
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")

            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }
        
        // 문자보내기 액션 예제
        smsBtn.setOnClickListener {
            // phoneNumEdt에 입력한 전화번호를 받아서 해당 번호에 문자메세지 전송
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("smsto:${inputPhoneNum}")

            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
            myIntent.putExtra("sms_body", "미리 전송할 내용 입력")
            startActivity(myIntent)
        }





        moveToOtherBtn.setOnClickListener {

            // 다른 화면으로 이동하기
            // Intent(출발지, 도착할 액티비티이름 :: class.java)
            val myIntent = Intent(this, OtherActivity::class.java)
            startActivity(myIntent) // 출발지, 도착지 정보가담긴 myIntent를 넣어준다.
        }




        // 다음 화면으로 넘어가면서 에딧텍스트 값도 같이 들고가기
        sendMessageBtn.setOnClickListener {
            // 에딧텍스트에서 입력한 내용을 저장
            val inputMessageBtn = messageEdt.text.toString()

            // 다른 화면으로 이동하기
            // Intent(출발지, 도착할 액티비티이름 :: class.java)
            val myIntent = Intent(this, MessageActivity::class.java)

            // myIntent에 putExtra("사용할 이름", 넘길 값)을 첨부
            myIntent.putExtra("message", inputMessageBtn)
            startActivity(myIntent)

        }

        // 닉네임 변경 버튼 클릭시
        editNicknameBtn.setOnClickListener {
            // 다른 화면으로 이동하기
            // Intent(출발지, 도착할 액티비티이름 :: class.java)
            val myIntent = Intent(this, EditNicknameActivity::class.java)

            // 다른화면으로 넘어갈때 닉네임을 가지러갈꺼다 하는 구문 
           startActivityForResult(myIntent, REQUEST_FOR_NICKNAME)
        }
    }

    // 닉네임 변경 완료후 변경 버튼 눌렀을 때 작동
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // 돌아온 이유가 닉네임을 받으러 다녀온게 맞는지?
        if(requestCode == REQUEST_FOR_NICKNAME){
            // 확인버튼을 눌러서 돌아온게 맞는가?
            if(resultCode == RESULT_OK){
                // 실제 새 닉네임을 꺼내 텍스트뷰에 반영
                val newNickname = data?.getStringExtra("nickName")
                nicknameTxt.text = newNickname
            }
        }
    }

}