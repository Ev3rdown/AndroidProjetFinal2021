package fr.epsi.thefinalproject

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class GroupActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)
        showBtnBack()
        setHeaderTitle(getString(R.string.txt_zone_group))

        val buttonYoann: Button = findViewById(R.id.buttonStudentYoann)
        val yoann = Student(fname="Yoann",lname="thebault",mail="yoann.thebault@epsi.fr", avatar=R.drawable.pp, group="(Han)Solo")

        buttonYoann.setOnClickListener {
            val intent = Intent(application, StudentActivity::class.java)
            intent.putExtra("student", yoann)
            val options = ActivityOptions.makeSceneTransitionAnimation(
                this,
                findViewById(R.id.layout_header),
                "TopBar"
            ).toBundle()
            startActivity(intent, options)
        }


    }
}