package com.example.dga_g.myapplication

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var valorTextoCentral = texto_central.text;
        //Log.i("clase", "El texto que se muestra antes es ${texto_central.text} o $valorTextoCentral")
//        texto_central.text="Nuevo Hola Mundo!"
        valorTextoCentral = texto_central.text;
        //Log.i("clase", "El texto que se muestra despues es ${texto_central.text} o $valorTextoCentral")

        Log.e("clase", "esto es un error")
        Log.w("clase", "esto es un warning")
        Log.d("clase", "esto es un debug")
        Log.i("clase", "esto es un info")
        Log.v("clase", "esto es un verbose")

        //code
        btn_actividad.setOnClickListener { v: View? ->
            irActividadDos()
        }

        val permission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA
        )
        Log.i("tag", "Crear permiso ${permission}")
        if (permission != PackageManager.PERMISSION_GRANTED) {
            //request de si hay el permiso
            Log.i("tag", "Entrando a pedir permiso")
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA, Manifest.permission.SEND_SMS), RESULTADO_PERMISO_CAMERA)
        } else {
            Log.i("tag", "Ya tiene este permiso")
        }

        btn_spinner_users.setOnClickListener(View.OnClickListener {
            irActividadSpinners()
        })

        btn_ciclo_vida.setOnClickListener(View.OnClickListener {
            irActividadCicloVida()
        })

        btn_framento.setOnClickListener(View.OnClickListener {
            irActividadFragmento()
        })
        btn_sqllite.setOnClickListener(View.OnClickListener {
            irActividadSQlite()
        })
    }

    fun irActividadSQlite() {
        val intent = Intent(this, SQLiteActivity::class.java)
        //pasar parametros a otra actividad
        intent.putExtra("nombre", "Nombre pasado")
        startActivity(intent)
    }

    fun irActividadFragmento() {
        val intent = Intent(this, FragmentosActivity::class.java)
        //pasar parametros a otra actividad
        intent.putExtra("nombre", "Nombre pasado")
        startActivity(intent)
    }


    fun irActividadDos() {
        val intent = Intent(this, Main2Activity::class.java)
        //pasar parametros a otra actividad
        intent.putExtra("nombre", "Nombre pasado")
        startActivity(intent)
    }

    fun irActividadCicloVida() {
        val intent = Intent(this, CicloVidaActivity::class.java)
        startActivity(intent)
    }

    fun irActividadSpinners() {
        val intent = Intent(this, SpinnerActivity::class.java)
        startActivity(intent)
    }

    companion object {
        val RESULTADO_PERMISO_CAMERA = 1
    }


}
