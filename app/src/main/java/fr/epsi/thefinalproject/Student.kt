package fr.epsi.thefinalproject

import java.io.Serializable

// Parcelable may be preferable for passing objects between intents, but Serializable
class Student (val fname:String,val lname:String,val mail:String,val avatar:Int,val group:String) : Serializable{

}