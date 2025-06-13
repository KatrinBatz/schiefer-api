package com.example.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName // ✅ WICHTIG: das hat gefehlt
import org.bson.codecs.pojo.annotations.BsonId

@Serializable
data class Deckung(
    @BsonId
    @SerialName("_id") // 👈 damit `"_id"` aus MongoDB als `id` gelesen wird
    val id: String = "",

    val name: String = "",
    val beschreibung: String = "",
    val bildUrl: String = "",
    val verwendung: List<String> = emptyList(),
    val schwierigkeitsgrad: String = ""
)