package com.example.dga_g.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.activity_fragmentos.*

class FragmentosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentos)

        //manager
        val fragmentManager = supportFragmentManager

        //transacciones
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragmentOne = Fragmento2()
        fragmentTransaction.add(R.id.rl_fragmento, fragmentOne)
        fragmentTransaction.commit()

        btn_tab1.setOnClickListener(View.OnClickListener {
            val fragmento1 = Fragmento1()
            cambiarFragmento(fragmento1)
        })

        btn_tab2.setOnClickListener(View.OnClickListener {
            val fragmento2 = Fragmento2()
            cambiarFragmento(fragmento2)
        })

        btn_tab3.setOnClickListener(View.OnClickListener {
            val fragmento3 = Fragmento3()
            cambiarFragmento(fragmento3)
        })

    }

    fun cambiarFragmento(fragmento: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.constraint_layout, fragmento)
        fragmentTransaction.commit()
    }
}
