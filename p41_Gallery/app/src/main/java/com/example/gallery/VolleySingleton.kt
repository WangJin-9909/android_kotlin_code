package com.example.gallery

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

/*构造器私有了*/
class VolleySingleton private constructor(context: Context) {
    companion object {
        /*在伴生对象中定义成员变量*/
        private var INSTANCE: VolleySingleton? = null

        /*在伴生对象中定义成员方法*/
        fun getInstance(context: Context) =
            INSTANCE ?: synchronized(this) {
                VolleySingleton(context).also { INSTANCE = it }

            }


    }

    /*todo：17：54*/
    val requestQueue: RequestQueue by lazy {
        /*延迟属性，花括号表示函数，下面的表示返回值，Kotlin可以省略*/
         Volley.newRequestQueue(context.applicationContext)
    }
}