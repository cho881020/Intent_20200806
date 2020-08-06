package kr.co.tjoeun.intent_20200806

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
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

    }
}