package fr.epsi.thefinalproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class StudentActivity : BaseActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        showBtnBack()

        val imageViewAvatar = findViewById<ImageView>(R.id.imageViewStudentAvatar)
        val textViewName = findViewById<TextView>(R.id.textViewStudentName)
        val textViewMail = findViewById<TextView>(R.id.textViewStudentMail)
        val textViewGroup = findViewById<TextView>(R.id.textViewStudentGroup)

        intent.getSerializableExtra("student")?.let{ it ->
            val student: Student = it as Student
            val fname = student.fname.lowercase().replaceFirstChar { that -> that.uppercase() }
            val lname = student.lname.uppercase()
            setHeaderTitle(fname)
            textViewName.text= "$fname $lname"
            textViewMail.text= student.mail
            textViewGroup.text= student.group
            imageViewAvatar.setImageResource(student.avatar)

        }
    }
}