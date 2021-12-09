package fr.epsi.thefinalproject

import android.app.Application
import android.widget.Toast

class AppFinalProject : Application() {

    fun showToast(txt : String){
        Toast.makeText(this,txt, Toast.LENGTH_SHORT).show()
    }

}