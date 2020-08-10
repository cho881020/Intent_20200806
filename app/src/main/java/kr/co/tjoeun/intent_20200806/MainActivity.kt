package kr.co.tjoeun.intent_20200806

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    1000이라는 숫자가 => 닉네임을 변경하는 요청이라는걸 인식하기 매우 어렵다.
//    별개의 멤버변수로 1000을 담아서, 이름을 보고 알 수 있도록 처리하자.
    val REQ_FOR_NICKNAME = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        문자 발송 화면 이동
        smsBtn.setOnClickListener {
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("smsto:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)

//            문자 전송 화면으로 이동시 => 미리 문구를 적어서 보내자.
//            myIntent를 가지고 갈때 => putExtra로 데이터를 담아서 보내자.
            myIntent.putExtra("sms_body", "이 앱을 ~~에서 설치해주세요.")

            startActivity(myIntent)
        }

//        call 버튼 누르면 => CALL 액션 실행되도록
        callBtn.setOnClickListener {
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }

        dialBtn.setOnClickListener {

            val inputPhoneNum = phoneNumEdt.text.toString()

//            어디에 전화를 걸지 Uri를 이용해서 정보 저장
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)
            startActivity(myIntent)

        }

        moveToFirstBtn.setOnClickListener {

//            FirstActivity로 이동하기 => Intent

            val myIntent = Intent(this, FirstActivity::class.java)
            startActivity(myIntent)

        }

        moveToSecondBtn.setOnClickListener {
//            SecondActivity로 => 입력한 내용을 들고 => 이동하기
            val inputMessage = messageEdt.text.toString()

            val myIntent = Intent(this, SecondActivity::class.java)
            
//            만들어준 Intent 변수에 데이터를 이름표를 붙인 상태로 첨부
            myIntent.putExtra("message", inputMessage)
            
            startActivity(myIntent)
        }

        changeNickNameBtn.setOnClickListener {
//            닉네임 변경화면으로 이동 => 새 닉네임을 받으러 이동한다고 명시

            val myIntent = Intent(this, EditNickNameActivity::class.java)

//            단순 이동 X, 결과를 받으러 이동 => 어떤 결과를 받으러 가는건지 명시.
//            => 고유 숫자를 임의로 지정해서 명시. => 멤버변수로 담아서 가독성 향상.
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)

        }

    }

//    결과를 받아올때 실행되는 함수 오버라이딩

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        requestCode를 우선 검사 => 뭘 가지러 다녀온건지 확인
//        닉네임을 가지러 다녀온게 맞는지? => requestCode의 값이 REQ_FOR_NICKNAME인지?
        if (requestCode == REQ_FOR_NICKNAME) {

//            닉네임 변경은 => 확인을 눌렀을때만 하고싶다.
//            확인이 눌린게 맞는지? => resultCode의 값이 RESULT_OK인지?

            if (resultCode == Activity.RESULT_OK) {

//                돌아올때 들고온 새 닉네임을 txt에 반영
//                data 인텐트가 => resultIntent를 들고 있다. => 거기(data)서 String을 뽑아내자.
                val newNickName = data?.getStringExtra("newNickName")

                nickNameTxt.text = newNickName

            }

        }

    }


}