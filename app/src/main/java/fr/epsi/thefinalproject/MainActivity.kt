package fr.epsi.thefinalproject

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setHeaderTitle(getString(R.string.epsi))
        (application as AppFinalProject).showToast("Welcome to the Final Project")

        val buttonZone1: Button = findViewById(R.id.buttonZone1)
        val buttonZone2: Button = findViewById(R.id.buttonZone2)

        buttonZone1.setOnClickListener {
            val intent = Intent(application, GroupActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(this,findViewById(R.id.layout_header),"TopBar").toBundle()
            startActivity(intent,options)
        }
        buttonZone2.setOnClickListener {
            val intent = Intent(application, CategoriesActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(this,findViewById(R.id.layout_header),"TopBar").toBundle()
            startActivity(intent, options)
        }
    }
}