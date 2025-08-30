package com.dappsm.kindbite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Donacion(
    val id: Int,
    var donador: String,
    var producto: String,
    var cantidad: String,
    var fecha: String
)

class DonacionesViewModel : ViewModel() {
    private val _donaciones = MutableLiveData<List<Donacion>>(
        listOf(
            Donacion(1,"Fernanda Gonzalez","Arroz","30kgs","20/08/25"),
            Donacion(2,"Mario Esparza","Pollo crudo (pechuga)","90kgs","23/08/25"),
            Donacion(3,"María Blas","Variedad de verduras","20kgs","07/08/25"),
            Donacion(4,"Bernardo Lopez","Leguminosas","120kgs","28/07/25")
        )
    )
    val donaciones: LiveData<List<Donacion>> = _donaciones

    fun editarDonacion(id: Int, nueva: Donacion) {
        _donaciones.value = _donaciones.value?.map {
            if (it.id == id) nueva else it
        }
    }

    fun agregarDonacion(nueva: Donacion) {
        _donaciones.value = _donaciones.value?.toMutableList()?.apply {
            add(nueva)
        }
    }
}