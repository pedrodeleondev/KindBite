package com.dappsm.kindbite

sealed class NavItem (
    var title:String,
    var icon:Int,
    var route:String
){
    object Home: NavItem("Home",R.drawable.home,"home")
    object User: NavItem("User",R.drawable.user,"user")
    object Inventory: NavItem("Inventory",R.drawable.inventory,"inventory")


}