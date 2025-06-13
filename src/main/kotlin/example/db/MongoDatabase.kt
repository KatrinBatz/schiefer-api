package com.example.db

import com.example.model.Deckung
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

object MongoDatabase {
    private val client = KMongo.createClient(
        "mongodb+srv://katrinbatz19:zrHx7UFivMzbfFpD@cluster0.xjag6oc.mongodb.net/schieferprofi?authSource=admin&retryWrites=true&w=majority"
    ).coroutine

    val database = client.getDatabase("schieferprofi") // Name frei wählbar
    val deckungen = database.getCollection<Deckung>("deckungen")
}