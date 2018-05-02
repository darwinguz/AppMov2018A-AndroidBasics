package com.example.dga_g.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View

import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.content_main2.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        setSupportActionBar(toolbar)


//        txt_recibido_3.text =

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        //code
        btn_pendiente.setOnClickListener { v: View? ->
            irMapa()
        }
    }

    fun irMapa() {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }
}
