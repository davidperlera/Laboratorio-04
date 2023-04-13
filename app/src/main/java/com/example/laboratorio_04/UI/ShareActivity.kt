package com.example.laboratorio_04.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.laboratorio_04.R

class ShareActivity : AppCompatActivity() {

    private  lateinit var  nameTextView: TextView
    private  lateinit var  emailTextView: TextView
    private  lateinit var  phoneTextView: TextView
    private lateinit var  actionShare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        bind()

        val name = intent.getStringExtra("name").toString()
        val email = intent.getStringExtra("email").toString()
        val phone = intent.getStringExtra("phone").toString()

        addListeners(name, email, phone)

        nameTextView.text = name
        emailTextView.text = email
        phoneTextView.text = phone
    }

    fun bind() {
        nameTextView = findViewById(R.id.name_text_view)
        emailTextView = findViewById(R.id.email_text_view)
        phoneTextView = findViewById(R.id.phone_text_view)
        actionShare = findViewById(R.id.share_action)
    }

    fun addListeners(name: String, email:String, phone: String){
        actionShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Nombre: ${name} Correo Electrónico: ${email} Número de teléfono: ${phone}")
            }
            startActivity(Intent.createChooser(intent, "Compartir con"))
        }
    }

}