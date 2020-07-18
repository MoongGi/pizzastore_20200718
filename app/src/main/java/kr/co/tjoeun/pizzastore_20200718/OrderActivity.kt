package kr.co.tjoeun.pizzastore_20200718

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_order.*
import kr.co.tjoeun.pizzastore_20200718.datas.PizzaStore

class OrderActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        setValues()
        setupEvents()

    }

    override fun setValues() {

    }

    override fun setupEvents()
    {
        val pizzaData = intent.getSerializableExtra("pizza") as PizzaStore
        agencyNameTxt.text = pizzaData.name
        ownerTelTxt.text = pizzaData.phoneNum
        Glide.with(mContext).load(pizzaData.logoUrl).into(pizzaImg)

        //권한 획득 여부에 따른 행동 방안을 변수에 저장
        //인터페이스를 익명 클래스에 올려서 변수에 담자.

        // 모든 권한이 승인된 겨웅에 실행할 내용
        btnCall.setOnClickListener {
            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted()
                {

                    // 모든 권한이 승인된 겨웅에 실행할 내용
                    val phoneNumTxt = Uri.parse("tel:${pizzaData.phoneNum}")
                    val phoneIntent = Intent(Intent.ACTION_CALL, phoneNumTxt)
                    startActivity(phoneIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?)
                {
                    // 하나라도 거부된 권한이 있다면 실행할 내용
                    Toast.makeText(mContext, "권한이 거부되어 사용할수 없습니다.", Toast.LENGTH_SHORT).show()
                }
            }


            //실제로 권한 확인을 요청하자
            TedPermission.with(mContext)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .setDeniedMessage("권한을 거부하면 통화 기능을 사용할수 없습니다. 설정에서 허용해 주세요.")
                .setPermissionListener(permissionListener)
                .check()
        }
    }
}
