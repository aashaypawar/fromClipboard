package com.example.fromclipboard

import android.content.ClipboardManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val pasteTxt = findViewById<TextView>(R.id.txtShow)
        val btnPaste = findViewById<Button>(R.id.btnShow)
        val clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager


        btnPaste.setOnClickListener {
            val pData = clipboardManager.primaryClip
            val item = pData!!.getItemAt(0)
            val txtPaste = item.text.toString()
            pasteTxt!!.text = txtPaste
            Toast.makeText(applicationContext, "Pasted from Clipboard", Toast.LENGTH_SHORT).show()
        }
    }
}

