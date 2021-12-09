package fr.epsi.thefinalproject

import androidx.appcompat.app.AppCompatActivity
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

        buttonZone1.setOnClickListener(View.OnClickListener {
            //val intent = Intent(application, CreateActivity::class.java)
            //startActivity(intent)
        })
        buttonZone2.setOnClickListener(View.OnClickListener {
            //val intent = Intent(application, CreateActivity::class.java)
            //startActivity(intent)
        })

    }
}