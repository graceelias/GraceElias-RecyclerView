package com.example.grace_elias_criminal_intent_recycler_view

import java.util.UUID
import java.util.Date

data class Crime(
    val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean
)