package kr.co.tjoeun.pizzastore_20200718

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity :AppCompatActivity()
{
    var mContext = this

    abstract fun setValues()
    abstract fun setupEvents()
}