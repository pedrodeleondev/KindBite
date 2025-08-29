package com.dappsm.kindbite

data class Usuario(val id:Int, val nombre:String, val tipoUsuario:String, val email:String, val contrasena:String)

object Sesion {
    var usuarioActual: Usuario? = null
}
fun usuariosBase():List<Usuario>{
    val usuarios = listOf(
        Usuario(0,"admin", "admin","admin@admin.com","admin"),
        Usuario(1,"general", "general","general@general.com","general")
    )
    return usuarios
}
fun compararUsuarios(n:String,c:String):Boolean{
    Sesion.usuarioActual = null
    val usuarios=usuariosBase();
    var concederAcceso:Boolean=false
    if(n.isNotEmpty() && c.isNotEmpty()){
        if(usuarios.any { it.nombre == n }){
            val u = usuarios.first { it.nombre == n }
            if(u.contrasena==c){
                println("Correcto")
                concederAcceso=true
                Sesion.usuarioActual=u
            }else{
                println("Incorrecto")
            }
        }else{
            println("Usuario inexistente")
        }
    }
    println(concederAcceso)
    return concederAcceso
}