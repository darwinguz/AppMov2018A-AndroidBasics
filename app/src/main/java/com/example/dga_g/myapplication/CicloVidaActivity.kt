package com.example.dga_g.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_ciclo_vida.*
import java.util.*


class CicloVidaActivity : AppCompatActivity() {
    //    var contador = 0
    var usuario: UsuarioParcelable? = UsuarioParcelable("Adrian", 1, Date(), false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclo_vida)
        Log.i("ciclo-vida", "Ejecuto: On Create")

//        val contadorGuardado: Int? = savedInstanceState?.get("contador") as Int?

        val usuarioGuardado: UsuarioParcelable? = savedInstanceState?.get("usuario") as UsuarioParcelable?

//        Log.i("ciclo-vida", "El contador es: $contadorGuardado")

//        if (contadorGuardado == null) {
//            text_view_contador.text = contador.toString()
//        } else {
//            text_view_contador.text = contadorGuardado.toString()
//            contador = contadorGuardado
//        }

        if (usuarioGuardado == null) {
            text_view_contador.text = usuario?.edad.toString()
        } else {
            text_view_contador.text = usuarioGuardado?.edad.toString()
            usuario = usuarioGuardado
        }

        boton_contador
                .setOnClickListener { view ->
                    if (usuario != null) {
                        usuario?.aumentarAnio(1)
//                        contador++
                        text_view_contador.text = usuario?.edad.toString()
                    }
                }


    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo-vida", "Ejecuto: On Start")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ciclo-vida", "Ejecuto: On Restart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo-vida", "Ejecuto: On Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo-vida", "Ejecuto: On Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo-vida", "Ejecuto: On Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo-vida", "Ejecuto: On Destroy")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        Log.i("ciclo-vida", "Ejecuto: On RestoreInstanceState")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        // outState?.putInt("contador", contador)
        outState?.putParcelable("usuario", usuario)

        Log.i("ciclo-vida", "Ejecuto: On SaveInstanceState")
    }
}
