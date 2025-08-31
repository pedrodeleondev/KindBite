package com.dappsm.kindbite

sealed class CUUsuariosScreen (val route:String) {
    object CUDonaciones: CUUsuariosScreen("CUDonaciones")
    object AdminUsuarios: CUUsuariosScreen("AdminUsuarios")

}