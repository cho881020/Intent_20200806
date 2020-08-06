package kr.co.tjoeun.intent_20200806

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        goBackToMainBtn.setOnClickListener {
//            val myIntent = Intent(this, MainActivity::class.java)
//            startActivity(myIntent)

//            인텐트를 만들면 새 액티비티가 추가된다. => 종료가 아님.

//            현재 액티비티 종료 코드
            finish()

        }

    }
}