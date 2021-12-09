package fr.epsi.thefinalproject

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    fun showBtnBack(){
        val imageViewBack = findViewById<ImageView>(R.id.imageViewHeaderGoBackImage)
        imageViewBack.visibility = View.VISIBLE
        imageViewBack.setOnClickListener {
            finish()
        }
    }
    fun setHeaderTitle(header: String){
        val textViewTitleHeader: TextView = findViewById(R.id.textViewHeaderTitleText)
        textViewTitleHeader.text = header
    }
}