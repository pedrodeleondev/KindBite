package com.dappsm.kindbite

data class Donacion(
    val id: Int,
    var donador: String,
    var producto: String,
    var cantidad: String,
    var fecha: String
)

object DonacionesRepo {

    private var donaciones : MutableList<Donacion> = mutableListOf(
        Donacion(1,"Fernanda Gonzalez","Arroz","30","20/08/25"),
        Donacion(2,"Mario Esparza","Pollo crudo (pechuga)","90","23/08/25"),
        Donacion(3,"María Blas","Variedad de verduras","20","07/08/25"),
        Donacion(4,"Bernardo Lopez","Leguminosas","120","28/07/25")
    )

    fun obtenerDonaciones() : List<Donacion> {
        val copia = mutableListOf<Donacion>()
        for(i in 0 until donaciones.size){
            val d = donaciones[i]
            copia.add(Donacion(d.id, d.donador, d.producto, d.cantidad, d.fecha))
        }
        return copia.toList()
    }

    fun editarDonacion(idTexto:String, donador:String, producto:String, cantidad:String, fecha:String){
        if(idTexto==null || idTexto==""){
            return
        } else {
            var id=0
            try {
                id=idTexto.toInt()
            } catch(e:Exception){
                return
            }

            val nuevaLista = mutableListOf<Donacion>()
            for (i in 0 until donaciones.size){
                val d=donaciones[i]
                if(d.id==id){
                    var nuevoDonador = d.donador
                    var nuevoProducto = d.producto
                    var nuevaCantidad = d.cantidad
                    var nuevaFecha = d.fecha
                    if(donador!=null && donador!=""){
                        nuevoDonador=donador
                    }
                    if(producto!=null && producto!=""){
                        nuevoProducto=producto
                    }
                    if(cantidad!=null && cantidad!=""){
                        nuevaCantidad=cantidad
                    }
                    if(fecha!=null && fecha!=""){
                        nuevaFecha=fecha
                    }
                    val nueva = Donacion(d.id,nuevoDonador,nuevoProducto,nuevaCantidad,nuevaFecha)
                    nuevaLista.add(nueva)
                } else {
                    val copia = Donacion(d.id,d.donador,d.producto,d.cantidad,d.fecha)
                    nuevaLista.add(copia)
                }
            }
            donaciones.clear()
            for(i in 0 until nuevaLista.size){
                donaciones.add(nuevaLista[i])
            }
        }
    }

    fun agregarDonacion(nueva:Donacion){
        if(nueva!=null){
            val listaTemp = mutableListOf<Donacion>()
            for (i in 0 until donaciones.size){
                listaTemp.add(donaciones[i])
            }
            listaTemp.add(Donacion(nueva.id,nueva.donador,nueva.producto,nueva.cantidad,nueva.fecha))
            donaciones= mutableListOf()
            for(i in 0 until listaTemp.size){
                donaciones.add(listaTemp[i])
            }
        }
    }
}
