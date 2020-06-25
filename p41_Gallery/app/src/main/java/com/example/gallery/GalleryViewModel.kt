package com.example.gallery

import android.app.Application
import android.app.DownloadManager
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.toolbox.StringRequest

import com.android.volley.Request;
import com.android.volley.Response
import com.google.gson.Gson

/*TODO:25:35*/
//AndridViewModel方便在代码中引用Context上下文，ViewModle不方便
class GalleryViewModel(application: Application) : AndroidViewModel(application) {
    /*ViewModel要管理的变量*/
    private val _photoListLive: MutableLiveData<List<PhotoItem>> = MutableLiveData()
    /*d对外可见*/
    val photoListLive: MutableLiveData<List<PhotoItem>>
        get() = _photoListLive

    fun fetchData() {
        /*定义变量*/
        val stringRequest: StringRequest = StringRequest(
            Request.Method.GET,
            getUrl(),
            Response.Listener {
                _photoListLive.value = Gson().fromJson(it, Pixabay::class.java).hits.toList()

            },/*成功的监听器*/
            Response.ErrorListener {
                Toast.makeText(getApplication(), it.toString(), Toast.LENGTH_SHORT).show()
            })/*失败的监听器*/
        VolleySingleton.getInstance(getApplication()).requestQueue.add(stringRequest)
    }

    private fun getUrl(): String {
        /*TODO:网址链接待丰富*/
        return "https://pixabay.com/api/?key=12472743-874dc01dadd26dc44e0801d61&q=${keyWords.random()}"
    }

    private val keyWords = arrayOf("cat", "dog", "car", "beauty", "computer", "flower", "animal")
}


