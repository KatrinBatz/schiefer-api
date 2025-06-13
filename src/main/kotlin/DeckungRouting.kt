package com.example

import com.example.db.MongoDatabase
import com.example.model.Deckung
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    routing {

        // ▶️ Alle Deckungen abrufen
        get("/deckungen") {
            val result: List<Deckung> = MongoDatabase.deckungen.find().toList()
            call.respond(result)
        }

        // ➕ Neue Deckung hinzufügen
        post("/deckungen") {
            val neueDeckung = call.receive<Deckung>()
            MongoDatabase.deckungen.insertOne(neueDeckung)
            call.respondText("✅ Gespeichert: ${neueDeckung.name}")
        }
    }
}