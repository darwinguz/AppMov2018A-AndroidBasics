package com.example.dga_g.myapplication

class Usuario(var nombre: String, var apellido: String, var colorFavorito: String) {

    override fun toString(): String {
        return "$nombre $apellido"
    }
}