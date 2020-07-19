package kr.co.tjoeun.pizzastore_20200718

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_nick_name.*

class EditNickNameActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nick_name)
        setValues()
        setupEvents()
    }

    override fun setValues() {

    }

    override fun setupEvents() {
        okBtn.setOnClickListener {

            val inputNickName = newNickNameEdt.text.toString()

            if (inputNickName.length < 5)
            {
                Toast.makeText(mContext, "닉네임은 최소 5글자 이상이여야 합니다.", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }

            var resultIntent = Intent()
            resultIntent.putExtra("nickName",inputNickName)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
