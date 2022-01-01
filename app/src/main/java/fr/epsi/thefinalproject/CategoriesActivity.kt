package fr.epsi.thefinalproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class CategoriesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        showBtnBack()
        setHeaderTitle(getString(R.string.categories))
        val categories = arrayListOf<Category>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCategories)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val categoryAdapter = CategoriesAdapter(categories,this)
        recyclerView.adapter = categoryAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL ="https://djemam.com/epsi/categories.json"
        val request = Request.Builder()
            .url(mRequestURL).get()
            .cacheControl(CacheControl.FORCE_NETWORK).build()

        okHttpClient.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.d("Error", e.toString())
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let{
                    val jOb= JSONObject(it)
                    val jAr =jOb.getJSONArray("items")
                    for(i in 0 until jAr.length()){
                        val jCa = jAr.getJSONObject(i)
                        val cat = Category(category_id = jCa.optString("category_id","tes"),
                            title = jCa.optString("title","test"),
                            products_url = jCa.optString("products_url","test"))
                        categories.add(cat)
                    }
                    runOnUiThread{
                        categoryAdapter.notifyDataSetChanged()
                    }
                }
            }
        })
    }
}