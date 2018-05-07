package com.example.dga_g.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_spinner.*

class SpinnerActivity : AppCompatActivity() {
    var arregloUsuarios = arrayListOf(
            Usuario("Darwin", "Guzman", "rojo"),
            Usuario("Freddy", "Alarcon", "blanco"),
            Usuario("Joss", "Gav", "fucsia")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)


        val adapterSpinnerUsuarios = ArrayAdapter<Usuario>(this, android.R.layout.simple_spinner_item, arregloUsuarios)

        adapterSpinnerUsuarios.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner_usuario.adapter = adapterSpinnerUsuarios

        spinner_usuario.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.i("spinner", "ID: $id \n Position: $position")
                val usuarioSeleccionado = arregloUsuarios.get(position)
                txt_nombre.text = usuarioSeleccionado.nombre
                txt_apellido.text = usuarioSeleccionado.apellido
                txt_color.text = usuarioSeleccionado.colorFavorito
            }

        }


    }


}
