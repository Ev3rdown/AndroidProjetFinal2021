package fr.epsi.thefinalproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ProductsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        showBtnBack()
        setHeaderTitle(intent.getStringExtra("title") ?: "Produits")

        val products = arrayListOf<Product>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProducts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val productsAdapter = ProductsAdapter(products,this)
        recyclerView.adapter = productsAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        intent.getStringExtra("products_url")?.let{ mRequestURL ->
            val request = Request.Builder()
                .url(mRequestURL).get()
                .cacheControl(CacheControl.FORCE_NETWORK).build()
            okHttpClient.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    //(application as AppFinalProject).showToast(getString(R.string.network_error))
                }

                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(call: Call, response: Response) {
                    response.body?.string()?.let{
                        val jOb= JSONObject(it)
                        val jAr =jOb.getJSONArray("items")
                        for(i in 0 until jAr.length()){
                            val jCa = jAr.getJSONObject(i)
                            val cat = Product(name = jCa.optString("name","tes"),
                                description = jCa.optString("description","test"),
                                picture_url = jCa.optString("picture_url","test"))
                            products.add(cat)
                        }
                        runOnUiThread{
                            productsAdapter.notifyDataSetChanged()
                        }
                    }
                }
            })
        }
    }
}