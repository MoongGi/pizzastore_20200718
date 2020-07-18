package kr.co.tjoeun.pizzastore_20200718

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.tjoeun.pizzastore_20200718.adapters.MainViewPagerAdapter

class MainActivity : BaseActivity() {

    lateinit var mvpa : MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setValues()
        setupEvents()
    }

    override fun setValues() {
        mvpa = MainViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = mvpa

        // 탭 레이아웃 + 뷰 페이저 연결
        myTabLayout.setupWithViewPager(viewPager)
    }

    override fun setupEvents() {
//        TODO("Not yet implemented")

    }
}
