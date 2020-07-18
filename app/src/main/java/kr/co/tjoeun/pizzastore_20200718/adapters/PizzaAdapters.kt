package kr.co.tjoeun.pizzastore_20200718.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import kr.co.tjoeun.pizzastore_20200718.R
import kr.co.tjoeun.pizzastore_20200718.datas.PizzaStore

class PizzaAdapters(val mContext: Context, val resId: Int, val mList: List<(PizzaStore)>) :
    ArrayAdapter<PizzaStore>(mContext, resId, mList)
{
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.pizza_item_list, null)

        }

        //이코드가 실행되는 시점 => tempRow 가 null 일 가능성이 없다
        val row = tempRow!!
        //!! : 절때 널이 아닐경우

        // row의 내용을 가공해서 사용
        val pizzaTxt = row.findViewById<TextView>(R.id.pizzaTxt)
        val pizzaImg = row.findViewById<CircleImageView>(R.id.pizzaImg)
        val phoneNumTxt = row.findViewById<TextView>(R.id.phoneNumTxt)

        // 뿌려줄 근거 데이터 가져오기
        val data = mList[position]


        pizzaTxt.text = data.name
        phoneNumTxt.text = data.phoneNum
        Glide.with(mContext).load(data.logoUrl).into(pizzaImg)

        return row
    }
}