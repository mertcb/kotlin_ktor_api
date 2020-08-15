package com.mertcb.sskotlin

import com.google.gson.Gson
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.request.receive
import io.ktor.response.respondText
import io.ktor.routing.*

val gson = Gson()

val users = arrayListOf("Mert","Steve","Paul")

fun Routing.users(){
    get("/users"){
        call.respondText(gson.toJson(users), ContentType.Application.Json)
    }
}

fun Routing.addUser(){
    post("/users/add"){
        val postVal: User= call.receive<User>()
        users.add(postVal.name)
        call.respondText("OK", ContentType.Application.Json)
    }
}

fun Routing.greetUser(){
    post("/users/greet"){
        val postVal: User= call.receive<User>()
        call.respondText("Hello, ${postVal.name}")
    }
}

