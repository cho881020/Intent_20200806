package kr.co.tjoeun.intent_20200806

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nick_name.*

class EditNickNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nick_name)

        okBtn.setOnClickListener {

//            완료버튼을 눌렀다 => 정말로 데이터를 들고 돌아가겠다 (확정) => 복귀 : finish()
//            백버튼을 눌러서 종료하는것과 구별해야함.

            finish()

        }

    }
}