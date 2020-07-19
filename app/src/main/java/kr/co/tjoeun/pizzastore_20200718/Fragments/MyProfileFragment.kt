package kr.co.tjoeun.pizzastore_20200718.Fragments

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_my_profile_fragment.*
import kr.co.tjoeun.pizzastore_20200718.EditNickNameActivity
import kr.co.tjoeun.pizzastore_20200718.R

class MyProfileFragment : Fragment()
{
    //닉네임 변경이 요청임을 구분하기 위한 숫자 저장
    val REQ_FOR_NICKNAME = 2003

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.activity_my_profile_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        changeNickBtn.setOnClickListener {
            val myIntent = Intent(activity, EditNickNameActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("테스트",  requestCode.toString())
        if (requestCode == REQ_FOR_NICKNAME)
        {
            if (resultCode == Activity.RESULT_OK)
            {
                val nickName = data?.getStringExtra("nickName")

                // nickName은 String? 라서 null일수 있지만 텍스트뷰가 처리한다.
                nickTxt.text = nickName
            }
        }
    }
}

