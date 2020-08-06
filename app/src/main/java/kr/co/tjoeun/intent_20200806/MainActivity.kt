package kr.co.tjoeun.intent_20200806

import android.content.Intent
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
}