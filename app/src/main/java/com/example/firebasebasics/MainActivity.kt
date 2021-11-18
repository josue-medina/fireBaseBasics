package com.example.firebasebasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.auth.User

private lateinit var database: DatabaseReference

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDB = FirebaseDatabase.getInstance()
        database = myDB.reference
        //database.setValue("hola mundo")
        //database.setValue("esta es una prueba de base de datod")

    }
        fun writeNewUser(userId: String, name: String, email: String){
            val user = User(name,email)

            database.child("users").child(userId).setValue(user)

        }


}

class User(name: String, email: String){
    val nombre=name
    val correo=email
}