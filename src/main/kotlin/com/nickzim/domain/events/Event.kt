package com.nickzim.domain.events

data class Event(
        val type: String,
        val group_id: Long,
        val `object`: EventObject?,
        val event_id: String?
)
