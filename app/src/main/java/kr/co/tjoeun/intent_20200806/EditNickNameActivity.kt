package kr.co.tjoeun.intent_20200806

import android.app.Activity
import android.content.Intent
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

//            돌아갈때 첨부할 데이터를 들고 있어주는 Intent 별개로 생성
            val resultIntent = Intent()

//            입력된 닉네임을 resultIntent에 첨부 - putExtra
            val inputNickName = nickNameEdt.text.toString()
            resultIntent.putExtra("newNickName", inputNickName)

//            OK버튼을 눌렀다고 명시 + 데이터를 담고 있는 resultIntent를 갖고 복귀하게.
            setResult(Activity.RESULT_OK, resultIntent)

            finish()

        }

    }
}