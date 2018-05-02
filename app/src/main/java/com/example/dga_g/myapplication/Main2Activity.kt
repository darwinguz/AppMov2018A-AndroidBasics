package com.example.dga_g.myapplication

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

//        val nombre = intent.getStringArrayExtra("nombre")
//        txt_nombre.text = nombre.toString()


        Log.i("nombre_obtenido", txt_nombre.text.toString())

        //code
        btn_actividad_2.setOnClickListener { v: View? ->
            irActividadTres()
        }

        btn_contacto.setOnClickListener(View.OnClickListener {
            seleccionarUnContacto();
        })

        btn_enviar_correo.setOnClickListener(View.OnClickListener {
            val addressees = arrayOf("direccion@unocom", "direccion@dos.com")
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/html"
            intent.putExtra(Intent.EXTRA_EMAIL, addressees)
            intent.putExtra(Intent.EXTRA_SUBJECT, "Sujeto")
            intent.putExtra(Intent.EXTRA_TEXT, "Texto enviado desde la app.")
            startActivity(intent)
        })

    }

    private fun seleccionarUnContacto() {
        val intent = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
        startActivityForResult(intent, RESPUESTA_DE_CONTACTO)
//        startActivityForResult(Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI), IDENTIFICADOR_DE_RESPUESTA)
    }

    companion object {
        val RESPUESTA_DE_CONTACTO = 1
    }

    fun irActividadTres() {
        val intent = Intent(this, Main3Activity::class.java)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
//        Log.i("etiqu", "El mensaje es: ",requestCode.toString())
        when (requestCode) {
            RESPUESTA_DE_CONTACTO -> {
                if (resultCode == RESULT_OK) {
                    var cursor: Cursor? = null
                    try {
                        var phoneNo: String? = null
                        var name: String? = null
                        val uri = intent?.data
                        cursor = contentResolver.query(uri, null, null, null, null)

                        //!! significa que puede ser nulo
                        cursor!!.moveToFirst()
                        val phoneIndex = cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                        val nameIndex = cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                        phoneNo = cursor!!.getString(phoneIndex)
                        name = cursor!!.getString(nameIndex)
                        Log.i("create", "Nombre ${name}")
                        Log.i("create", "Numero de telefono ${phoneNo}")
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                if (resultCode == RESULT_CANCELED) {
                    Log.i("create", "Algo salio mal")
                }
            }
        }
    }

}
