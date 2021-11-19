package com.example.firebasebasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
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

        //writeNewUser("100","JOSUE","josue@correo.com")
        //database.setValue("hola mundo")
        //database.setValue("esta es una prueba de base de datod")

        val etId = findViewById<EditText>(R.id.etUserId)
        val etNombre = findViewById<EditText>(R.id.etUserName)
        val etCorreo = findViewById<EditText>(R.id.etUserEmail)
        val btnSend = findViewById<Button>(R.id.btnSet)
        btnSend.setOnClickListener {
            writeNewUser(etId.text.toString(), etNombre.text.toString(), etCorreo.text.toString())
            //se limpia las casillas
            etId.text.clear()
            etNombre.text.clear()
            etCorreo.text.clear()
        }
        //getUser()

    }


        //
        fun borrar(userId: String){
            database.child("usuarios").child(userId).removeValue()
        }

        fun getUser(userId: String){
            database.child("usuarios").child(userId).get().addOnSuccessListener { record ->
                Log.d("valores_de_ejemplo","got value ${record.value}")
            }  //.addOnFailureListener { record -> Log.d("valores_de_ejemplo", "ERROR: ${record}") }
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