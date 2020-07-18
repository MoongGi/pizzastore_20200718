package kr.co.tjoeun.pizzastore_20200718.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_pizza_store_list_fragment.*
import kr.co.tjoeun.pizzastore_20200718.OrderActivity
import kr.co.tjoeun.pizzastore_20200718.R
import kr.co.tjoeun.pizzastore_20200718.adapters.PizzaAdapters
import kr.co.tjoeun.pizzastore_20200718.datas.PizzaStore

class PizzaStoreListFragment : Fragment()
{
    val mBang =ArrayList<PizzaStore>()

    lateinit var mAdapters:PizzaAdapters

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.activity_pizza_store_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mAdapters = PizzaAdapters(this.context!!, R.layout.activity_pizza_store_list_fragment, mBang)
        pizzalistView.adapter = mAdapters

        mBang.add(PizzaStore("피자헛","010-1234-5678","https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg"))
        mBang.add(PizzaStore("파파존스","010-3344-5221","http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800"))
        mBang.add(PizzaStore("미스터피자","010-1244-0000","https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200"))
        mBang.add(PizzaStore("도미노피자","010-1554-5666","https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png"))
        mAdapters.notifyDataSetChanged()

        pizzalistView.setOnItemClickListener { parent, view, position, id ->
            //어떤방을 선택했는지
            val clickedRoom = mBang[position]

            //상세 화면으로 진입

            val myIntent = Intent(context, OrderActivity::class.java)
            myIntent.putExtra("pizza", clickedRoom)
            startActivity(myIntent)
        }
    }
}
