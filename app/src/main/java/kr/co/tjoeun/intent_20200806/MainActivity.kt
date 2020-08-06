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

    }
}